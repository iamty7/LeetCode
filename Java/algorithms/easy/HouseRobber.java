package easy;

public class HouseRobber {
	/*
	 * You are a professional robber planning to rob houses along a street. Each
	 * house has a certain amount of money stashed, the only constraint stopping
	 * you from robbing each of them is that adjacent houses have security
	 * system connected and it will automatically contact the police if two
	 * adjacent houses were broken into on the same night.
	 * 
	 * Given a list of non-negative integers representing the amount of money of
	 * each house, determine the maximum amount of money you can rob tonight
	 * without alerting the police.
	 */

	public int rob(int[] nums) {
		// Your runtime beats 43.15% of java submissions. Runtime 0ms
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];

		int[] max = new int[nums.length];
		max[0] = nums[0];
		max[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			max[i] = Math.max(max[i - 2] + nums[i], max[i - 1]);
		}
		return max[nums.length - 1];
	}
}
