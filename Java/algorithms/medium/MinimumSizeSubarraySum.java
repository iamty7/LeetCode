package medium;

public class MinimumSizeSubarraySum {
	/*
	 * Given an array of n positive integers and a positive integer s, find the
	 * minimal length of a contiguous subarray of which the sum ≥ s. If there
	 * isn't one, return 0 instead.
	 * 
	 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3]
	 * has the minimal length under the problem constraint.
	 * 
	 * More practice: If you have figured out the O(n) solution, try coding
	 * another solution of which the time complexity is O(n log n).
	 */
	public int minSubArrayLen(int s, int[] nums) {
		// O(n)
		// Your runtime beats 28.17% of java submissions. Runtime 3ms
		if (nums.length == 0)
			return 0;
		int len = nums.length + 1, sum = nums[0];
		int i = 0, j = 0;
		while (j < nums.length) {
			if (sum >= s) {
				len = Math.min(len, j - i + 1);
				if (len == 1)
					return 1;
				sum -= nums[i++];
			} else if (++j < nums.length)
				sum += nums[j];
		}
		return len == nums.length + 1 ? 0 : len;
	}
}
