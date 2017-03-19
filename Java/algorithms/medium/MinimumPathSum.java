package medium;

import java.util.Arrays;
import sun.security.util.Length;

public class MinimumPathSum {
	/*
	 * Given a m x n grid filled with non-negative numbers, find a path from top
	 * left to bottom right which minimizes the sum of all numbers along its
	 * path.
	 * 
	 * Note: You can only move either down or right at any point in time.
	 */

	public int minPathSum(int[][] grid) {
		// Your runtime beats 87.96% of java submissions. Runtime 3ms
		int m = grid.length, n = grid[0].length;

		int[] sums = new int[n];

		for (int i = n - 1; i > -1; i--)
			sums[i] = grid[m - 1][i] + (i == n - 1 ? 0 : sums[i + 1]);

		for (int i = m - 2; i > -1; i--) {

			sums[n - 1] = grid[i][n - 1] + sums[n - 1];
			for (int j = sums.length - 2; j > -1; j--) {
				sums[j] = Math.min(sums[j], sums[j + 1]) + grid[i][j];
			}
		}

		return sums[0];
	}
}
