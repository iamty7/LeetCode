package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
	/*
	 * Given an array S of n integers, are there elements a, b, c in S such that
	 * a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero.
	 * 
	 * Note: The solution set must not contain duplicate triplets.
	 * 
	 * For example, given array S = [-1, 0, 1, 2, -1, -4],
	 * 
	 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
	 */

	public List<List<Integer>> threeSum(int[] nums) {
		// Your runtime beats 18.32% of java submissions. Runtime 111ms
		List<List<Integer>> list = new LinkedList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				if (nums[left] + nums[right] == -nums[i]) {
					list.add(Arrays.asList(nums[i], nums[left], nums[right]));
					while (left < right && nums[left] == nums[left + 1])
						left++;
					while (right > left && nums[right] == nums[right - 1])
						right--;
					left++;
					right--;
				} else if (nums[left] + nums[right] > -nums[i]) {
					right--;
					while (right > left && nums[right] == nums[right + 1])
						right--;
				} else {
					left++;
					while (left < right && nums[left] == nums[left - 1])
						left++;
				}
			}
			while (i + 1 < nums.length && nums[i] == nums[i + 1])
				i++;
		}
		return list;
	}
}
