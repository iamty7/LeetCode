package medium;

import java.util.Arrays;

public class JumpGame {
	/*
	 * Given an array of non-negative integers, you are initially positioned at
	 * the first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Determine if you are able to reach the last index.
	 * 
	 * For example: A = [2,3,1,1,4], return true. A = [3,2,1,0,4], return false.
	 */

	public boolean canJump(int[] nums) {
		// Time Limit Exceeded
		int[] farest = new int[nums.length];
		Arrays.fill(farest, Integer.MAX_VALUE);
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j <= nums[i] && i + j < nums.length; j++) {
				farest[i + j] = Math.min(farest[i + j], i);
				farest[i + j] = Math.min(farest[i + j], farest[i]);
			}
		}
		return farest[nums.length - 1] == 0;
	}

	public boolean canJump2(int[] nums) {
		// Time Limit Exceeded
		return helper(nums, 0);
	}

	private boolean helper(int[] nums, int i) {
		if (i + nums[i] >= nums.length - 1)
			return true;

		int step = nums[i] - 1;
		while (step > 0) {
			if (helper(nums, i + step))
				return true;
			step--;
		}
		return false;
	}

	public boolean canJump3(int[] nums) {
		// Time Limit Exceeded
		boolean[] results = new boolean[nums.length];
		results[nums.length - 1] = true;
		for (int i = nums.length - 2; i >= 0; i--) {
			for (int j = Math.min(nums[i], nums.length - 1 - i); j > 0; j--)
				if (results[i + j]) {
					results[i] = true;
					break;
				}
		}
		return results[0];
	}

	public boolean canJump4(int[] nums) {
		// !! Or from beginning to end
		// Your runtime beats 36.45% of java submissions. Runtime 9ms
		int flag = nums.length - 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (i + nums[i] >= flag)
				flag = i;
		}
		return flag <= 0;
	}

	public boolean canJump5(int[] nums) {
		// Your runtime beats 36.45% of java submissions. Runtime 9ms
		int reachable = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (i > reachable)
				return false;
			reachable = Math.max(reachable, i + nums[i]);
		}
		return true;
	}

}
