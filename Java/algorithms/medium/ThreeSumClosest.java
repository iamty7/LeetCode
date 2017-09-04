package medium;

import java.util.Arrays;

public class ThreeSumClosest {
	/*
	 * Given an array S of n integers, find three integers in S such that the
	 * sum is closest to a given number, target. Return the sum of the three
	 * integers. You may assume that each input would have exactly one solution.
	 * 
	 * For example, given array S = {-1 2 1 -4}, and target = 1.
	 * 
	 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 */
	public int threeSumClosest(int[] nums, int target) {
		// Your runtime beats 82.80% of java submissions. Runtime 21ms
		if (nums.length <= 2)
			return -1;
		int sum = nums[0] + nums[1] + nums[2];
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				int curSum = nums[i] + nums[left] + nums[right];
				if (curSum == target)
					return target;
				else if (curSum > target) {
					right--;
					while (right > left && nums[right] == nums[right + 1])
						right--;
				} else {
					left++;
					while (right > left && nums[left - 1] == nums[left])
						left++;
				}
				if (Math.abs(curSum - target) < Math.abs(sum - target))
					sum = curSum;
			}
			while (i + 1 < nums.length - 1 && nums[i] == nums[i + 1])
				i++;
		}
		return sum;
	}
	
	public int threeSumClosest2(int[] nums, int target) {
		//Your runtime beats 75.82 % of java submissions. 21ms
		Arrays.sort(nums);
		int ret = nums[0]+nums[1]+nums[2];
		int tmpDist = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				if (Math.abs(nums[i] + nums[j] + nums[k] - target) < tmpDist) {
					tmpDist = Math.abs(nums[i] + nums[j] + nums[k] - target);
					ret = nums[i] + nums[j] + nums[k];
					if (ret == target)
						return target;
				}
				if (nums[i] + nums[j] + nums[k] > target)
					k--;
				else
					j++;
			}
			while (i < nums.length - 2 && nums[i] == nums[i + 1])
				i++;
		}
		return ret;
	}
}
