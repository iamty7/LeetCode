package medium;

public class LongestPalindromicSubsequence {

	/*
	 * Given a string s, find the longest palindromic subsequence's length in s.
	 * You may assume that the maximum length of s is 1000.
	 * 
	 * Example 1: Input:
	 * 
	 * "bbbab" Output: 4 One possible longest palindromic subsequence is "bbbb".
	 * Example 2: Input:
	 * 
	 * "cbbd" Output: 2 One possible longest palindromic subsequence is "bb".
	 */

	public int longestPalindromeSubseq(String s) {
		// !!
		// Your runtime beats 68.95% of java submissions. Runtime 62ms
		int[][] dp = new int[s.length()][s.length()];

		// From back to forth to initialize the dp[i][i] first
		for (int i = s.length() - 1; i > -1; i--) {
			dp[i][i] = 1;
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j))
					dp[i][j] = dp[i + 1][j - 1] + 2;
				else
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
			}
		}
		return dp[0][s.length() - 1];
	}

	public int longestPalindromeSubseq2(String s) {
		// Recursion
		// Your runtime beats 96.99% of java submissions. Runtime 45ms
		return helper(s, 0, s.length() - 1, new int[s.length()][s.length()]);
	}

	private int helper(String s, int i, int j, int[][] dp) {
		if (dp[i][j] != 0)
			return dp[i][j];
		if (i == j)
			return 1;
		if (i > j)
			return 0;
		if (s.charAt(i) == s.charAt(j))
			dp[i][j] = helper(s, i + 1, j - 1, dp) + 2;
		else
			dp[i][j] = Math.max(helper(s, i + 1, j, dp), helper(s, i, j - 1, dp));

		return dp[i][j];
	}

	public int longestPalindromeSubseq3(String s) {
		// ???
		// Your runtime beats 98.38% of java submissions. Runtime 41ms
		int n = s.length();
		int[] dp = new int[n];
		for (int j = 0; j < n; ++j) {
			dp[j] = 1;
			int prev = 0;
			for (int i = j - 1; i >= 0; --i) {
				int tmp = dp[i];
				if (s.charAt(i) == s.charAt(j)) {
					dp[i] = 2 + prev;
				} else {
					dp[i] = Math.max(dp[i + 1], dp[i]);
				}
				prev = tmp;
			}
		}
		return dp[0];
	}
}
