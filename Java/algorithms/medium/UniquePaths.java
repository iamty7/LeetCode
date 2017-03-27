package medium;

import java.util.Arrays;

public class UniquePaths {

	/*
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start'
	 * in the diagram below).
	 * 
	 * The robot can only move either down or right at any point in time. The
	 * robot is trying to reach the bottom-right corner of the grid (marked
	 * 'Finish' in the diagram below).
	 * 
	 * How many possible unique paths are there?
	 * 
	 * 
	 * Above is a 3 x 7 grid. How many possible unique paths are there?
	 * 
	 * Note: m and n will be at most 100.
	 * 
	 */
	public int uniquePaths(int m, int n) {
		// Your runtime beats 6.50% of java submissions. Runtime 1ms
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for (int i = m - 2; i >= 0; i--)
			for (int j = n - 2; j >= 0; j--)
				dp[j] = dp[j] + dp[j + 1];

		return dp[0];
	}
}
