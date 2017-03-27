package medium;

import java.util.Arrays;

public class UniquePathsII {
	/*
	 * Follow up for "Unique Paths":
	 * 
	 * Now consider if some obstacles are added to the grids. How many unique
	 * paths would there be?
	 * 
	 * An obstacle and empty space is marked as 1 and 0 respectively in the
	 * grid.
	 * 
	 * For example, There is one obstacle in the middle of a 3x3 grid as
	 * illustrated below.
	 * 
	 * [ [0,0,0], [0,1,0], [0,0,0] ] The total number of unique paths is 2.
	 * 
	 * Note: m and n will be at most 100.
	 */

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// Your runtime beats 18.12% of java submissions. Runtime 1ms
		if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[] dp = new int[n];
		for (int j = n - 1; j >= 0; j--) {
			if (obstacleGrid[m - 1][j] == 1) {
				for (int k = j; k >= 0; k--)
					dp[k] = 0;
				break;
			} else
				dp[j] = 1;
		}
		for (int i = m - 2; i >= 0; i--)
			for (int j = n - 1; j >= 0; j--) {
				if (obstacleGrid[i][j] == 1)
					dp[j] = 0;
				else
					dp[j] = dp[j] + (j == n - 1 ? 0 : dp[j + 1]);
			}
		return dp[0];
	}
}
