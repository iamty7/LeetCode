package string.easy;

public class RepeatedSubstringPattern {
	/*
	 * Given a non-empty string check if it can be constructed by taking a
	 * substring of it and appending multiple copies of the substring together.
	 * You may assume the given string consists of lowercase English letters
	 * only and its length will not exceed 10000.
	 * 
	 * Example 1: Input: "abab"
	 * 
	 * Output: True
	 * 
	 * Explanation: It's the substring "ab" twice. Example 2: Input: "aba"
	 * 
	 * Output: False Example 3: Input: "abcabcabcabc"
	 * 
	 * Output: True
	 * 
	 * Explanation: It's the substring "abc" four times. (And the substring
	 * "abcabc" twice.)
	 */

	public boolean solution(String s) {
		// !!Very inefficient
		// Your runtime beats 3.59% of java submissions. Runtime 525ms
		int sub_len = 1;
		// repeat substring at least 2 or 3 times
		int end = s.length() % 2 == 0 ? s.length() / 2 : s.length() / 3;

		int i;
		for (i = 1; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(i % sub_len)) {
				sub_len++;
				/*
				 * !!add this line to avoid invalid sub_len and then Your
				 * runtime beats 43.90% of java submissions. Runtime 57ms while
				 * (s.length() % sub_len != 0) sub_len++;
				 */
				i = sub_len;
				if (sub_len > end)
					return false;
			}
		}

		// If the last repeat is not complete return false
		if (i % sub_len != 0 || sub_len == s.length())
			return false;
		return true;
	}

	public boolean solution2(String s) {
		// Your runtime beats 24.10% of java submissions. Runtime 87ms
		int s_len = s.length();

		for (int i = s_len / 2; i > 0; i--) {
			if (s_len % i == 0) {
				int m = s_len / i;
				StringBuffer sBuffer = new StringBuffer();
				for (int j = 0; j < m; j++)
					sBuffer.append(s.substring(0, i));
				if (sBuffer.toString().equals(s))
					return true;
			}

		}

		return false;
	}

}
