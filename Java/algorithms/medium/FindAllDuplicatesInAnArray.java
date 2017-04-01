package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
	/*
	 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some
	 * elements appear twice and others appear once.
	 * 
	 * Find all the elements that appear twice in this array.
	 * 
	 * Could you do it without extra space and in O(n) runtime?
	 * 
	 * Example: Input: [4,3,2,7,8,2,3,1]
	 * 
	 * Output: [2,3]
	 */

	public List<Integer> findDuplicates(int[] nums) {
		// Your runtime beats 84.81% of java submissions. Runtime 16ms
		int bound = nums.length + 1;
		List<Integer> ret = new LinkedList<>();
		for (int n : nums) {
			nums[n % bound - 1] += bound;
		}
		for (int i = 0; i < nums.length; i++) {
			// set the nums[i] to nums[i]%bound to keep input unchanged
			if (nums[i] / bound >= 2)
				ret.add(i + 1);
		}
		return ret;
	}

	public List<Integer> findDuplicates2(int[] nums) {
		// A number would be added to the list more than once if it appears more
		// than 4 times in the array
		// Your runtime beats 41.11% of java submissions. Runtime 20ms
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; ++i) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0)
				res.add(Math.abs(index + 1));
			nums[index] = -nums[index];
		}
		return res;
	}
}
