package medium;

public class DecodeWays {
	/*
	 * A message containing letters from A-Z is being encoded to numbers using
	 * the following mapping:
	 * 
	 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing
	 * digits, determine the total number of ways to decode it.
	 * 
	 * For example, Given encoded message "12", it could be decoded as "AB" (1
	 * 2) or "L" (12).
	 * 
	 * The number of ways decoding "12" is 2.
	 */

	public int solution(String s) {
		// !!
		// Your runtime beats 69.24% of java submissions. Runtime 3ms
		int n = s.length();
		if (n == 0)
			return 0;

		int[] memo = new int[n + 1];
		memo[n] = 1;
		memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

		for (int i = n - 2; i >= 0; i--)
			if (s.charAt(i) == '0')
				continue;
			else
				memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];

		return memo[0];
	}

	public int solution2(String s) {
		// !!
		// Your runtime beats 74.49% of java submissions. Runtime 2ms
		if (s.length() != 0 || s.charAt(0) == '0')
			return 0;
		// r2: decode ways of s[i-2] , r1: decode ways of s[i-1]
		int r1 = 1, r2 = 1;

		for (int i = 1; i < s.length(); i++) {
			// zero voids ways of the last because zero cannot be used
			// separately
			if (s.charAt(i) == '0')
				r1 = 0;

			// possible two-digit letter, so new r1 is sum of both while new r2
			// is the old r1
			if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
				r1 = r2 + r1;
				r2 = r1 - r2;
			}
			// one-digit letter, no new way added
			else {
				r2 = r1;
			}
		}

		return r1;
	}
}
