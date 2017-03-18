package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
	/*
	 * You are given two arrays (without duplicates) nums1 and nums2 where
	 * nums1’s elements are subset of nums2. Find all the next greater numbers
	 * for nums1's elements in the corresponding places of nums2.
	 * 
	 * The Next Greater Number of a number x in nums1 is the first greater
	 * number to its right in nums2. If it does not exist, output -1 for this
	 * number.
	 * 
	 * Example 1: Input: nums1 = [4,1,2], nums2 = [1,3,4,2]. Output: [-1,3,-1]
	 * Explanation: For number 4 in the first array, you cannot find the next
	 * greater number for it in the second array, so output -1. For number 1 in
	 * the first array, the next greater number for it in the second array is 3.
	 * For number 2 in the first array, there is no next greater number for it
	 * in the second array, so output -1. Example 2: Input: nums1 = [2,4], nums2
	 * = [1,2,3,4]. Output: [3,-1] Explanation: For number 2 in the first array,
	 * the next greater number for it in the second array is 3. For number 4 in
	 * the first array, there is no next greater number for it in the second
	 * array, so output -1. Note: All elements in nums1 and nums2 are unique.
	 * The length of both nums1 and nums2 would not exceed 1000.
	 */

	public int[] solution(int[] findNums, int[] nums) {
		// Your runtime beats 20.94% of java submissions. Runtime 17ms
		List<Integer> retInteger = new ArrayList<>();
		MainLoop: for (int num : findNums) {
			for (int i = 0; i < nums.length; i++)
				if (num == nums[i]) {
					for (int j = i + 1; j < nums.length; j++)
						if (nums[j] > num) {
							retInteger.add(nums[j]);
							continue MainLoop;
						}
					retInteger.add(-1);
					continue MainLoop;
				}
		}

		int[] retArray = new int[retInteger.size()];
		for (int i = 0; i < retArray.length; i++)
			retArray[i] = retInteger.get(i);
		return retArray;
	}

	public int[] solution2(int[] findNums, int[] nums) {
		// !!
		// Your runtime beats 45.40% of java submissions. Runtime 12ms
		Map<Integer, Integer> myMap = new HashMap<>();
		Stack<Integer> numsStack = new Stack<>();

		for (int n : nums) {
			while (!numsStack.isEmpty() && numsStack.peek() < n)
				myMap.put(numsStack.pop(), n);
			numsStack.push(n);
		}
		int[] ret = new int[findNums.length];
		int i = 0;
		for (int n : findNums)
			ret[i++] = myMap.get(n) != null ? myMap.get(n) : -1;

		return ret;
	}
	
}
