package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
	/*
	 * Given an array S of n integers, are there elements a, b, c, and d in S
	 * such that a + b + c + d = target? Find all unique quadruplets in the
	 * array which gives the sum of target.
	 * 
	 * Note: The solution set must not contain duplicate quadruplets.
	 * 
	 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
	 * 
	 * A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
	 */

	public List<List<Integer>> fourSum(int[] nums, int target) {
		// Your runtime beats 34.52% of java submissions. Runtime 85ms
		Arrays.sort(nums);
		List<List<Integer>> list = new LinkedList<>();
		for (int i = 0; i < nums.length - 3; i++) {
			threeSum(list, nums, i + 1, nums[i], target - nums[i]);
			while (i + 1 < nums.length - 3 && nums[i] == nums[i + 1])
				i++;
		}
		return list;
	}

	// In the threeSum and also the twoSum method you can compare
	// 2*min,2*max,3*min,3*max to target respectively in each loop
	private void threeSum(List<List<Integer>> list, int[] nums, int start, int firstEle, int curTarget) {
		for (int i = start; i < nums.length; i++) {
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				if (nums[left] + nums[right] == curTarget - nums[i]) {
					list.add(Arrays.asList(firstEle, nums[i], nums[left], nums[right]));
					while (left < right && nums[left] == nums[left + 1])
						left++;
					while (right > left && nums[right] == nums[right - 1])
						right--;
					left++;
					right--;
				} else if (nums[left] + nums[right] > curTarget - nums[i]) {
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
	}
}
