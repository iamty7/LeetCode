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

	public List<List<Integer>> threeSum2(int[] nums) {
		// Your runtime beats 28.82 % of java submissions. Runtime 96ms
		// Slightly improved from solution1
		List<List<Integer>> ret = new LinkedList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				int mid = (j + k) / 2;
				if (nums[i] + nums[j] + nums[k] == 0) {
					ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
					while (j < k && nums[j] == nums[j + 1])
						j++;
					while (j < k && nums[k] == nums[k - 1])
						k--;
					j++;
					k--;
				} else if (nums[j] + nums[k] > -nums[i]) {
					k--;
					if (nums[mid] + nums[j] > -nums[i])
						k = mid - 1;
				} else {
					j++;
					if (nums[k] + nums[mid] < -nums[i])
						j = mid + 1;
				}
			}
			while (i < nums.length - 2 && nums[i] == nums[i + 1])
				i++;
		}
		return ret;
	}
}
