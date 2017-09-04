package medium;

import java.util.ArrayList;
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

	public List<List<Integer>> fourSum2(int[] nums, int target) {
		// Your runtime beats 55.11 % of java submissions. Runtime 70ms
		Arrays.sort(nums);
		List<List<Integer>> list = new LinkedList<>();
		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				int k = j + 1, l = nums.length - 1;
				while (k < l) {
					if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
						list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
						while (k < l && nums[k] == nums[k + 1])
							k++;
						while (k < l && nums[l] == nums[l - 1])
							l--;
						k++;
						l--;
					} else if (nums[i] + nums[j] + nums[k] + nums[l] > target)
						l--;
					else
						k++;
				}
				while (j < nums.length - 2 && nums[j] == nums[j + 1])
					j++;
			}
			while (i < nums.length - 3 && nums[i] == nums[i + 1])
				i++;
		}
		return list;
	}

	public List<List<Integer>> fourSum3(int[] nums, int target) {
		// Your runtime beats 95.12 % of java submissions. Runtime 25ms
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		int len = nums.length;
		if (nums == null || len < 4)
			return res;

		Arrays.sort(nums);

		int max = nums[len - 1];
		if (4 * nums[0] > target || 4 * max < target)
			return res;

		int i, z;
		for (i = 0; i < len; i++) {
			z = nums[i];
			if (i > 0 && z == nums[i - 1])// avoid duplicate
				continue;
			if (z + 3 * max < target) // z is too small
				continue;
			if (4 * z > target) // z is too large
				break;
			if (4 * z == target) { // z is the boundary
				if (i + 3 < len && nums[i + 3] == z)
					res.add(Arrays.asList(z, z, z, z));
				break;
			}

			threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
		}

		return res;
	}

	/*
	 * Find all possible distinguished three numbers adding up to the target in
	 * sorted array nums[] between indices low and high. If there are, add all
	 * of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, the three numbers))
	 */
	public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
			int z1) {
		if (low + 1 >= high)
			return;

		int max = nums[high];
		if (3 * nums[low] > target || 3 * max < target)
			return;

		int i, z;
		for (i = low; i < high - 1; i++) {
			z = nums[i];
			if (i > low && z == nums[i - 1]) // avoid duplicate
				continue;
			if (z + 2 * max < target) // z is too small
				continue;

			if (3 * z > target) // z is too large
				break;

			if (3 * z == target) { // z is the boundary
				if (i + 1 < high && nums[i + 2] == z)
					fourSumList.add(Arrays.asList(z1, z, z, z));
				break;
			}

			twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
		}

	}

	/*
	 * Find all possible distinguished two numbers adding up to the target in
	 * sorted array nums[] between indices low and high. If there are, add all
	 * of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
	 */
	public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
			int z1, int z2) {

		if (low >= high)
			return;

		if (2 * nums[low] > target || 2 * nums[high] < target)
			return;

		int i = low, j = high, sum, x;
		while (i < j) {
			sum = nums[i] + nums[j];
			if (sum == target) {
				fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

				x = nums[i];
				while (++i < j && x == nums[i]) // avoid duplicate
					;
				x = nums[j];
				while (i < --j && x == nums[j]) // avoid duplicate
					;
			}
			if (sum < target)
				i++;
			if (sum > target)
				j--;
		}
		return;
	}
}
