package string.easy;

public class LengthOfLastWord {
	/*
	 * Given a string s consists of upper/lower-case alphabets and empty space
	 * characters ' ', return the length of last word in the string.
	 * 
	 * If the last word does not exist, return 0.
	 * 
	 * Note: A word is defined as a character sequence consists of non-space
	 * characters only.
	 * 
	 * For example, Given s = "Hello World", return 5.
	 */

	public int solution(String s) {
		// Your runtime beats 14.45% of java submissions. Runtime 9ms
		if (s.length() == 0)
			return 0;

		int len = 0;
		for (int i = s.length() - 1; i > -1; i--) {
			if (s.charAt(i) != ' ')
				len++;
			else if (len != 0)
				break;
		}

		return len;
	}

	public int solution2(String s) {
		// Use java method
		// Your runtime beats 73.32% of java submissions. Runtime 5ms
		String trimedStr = s.trim();
		return trimedStr.lastIndexOf(' ') == -1 ? (trimedStr.length() != 0 ? trimedStr.length() : 0)
				: (trimedStr.length() - trimedStr.lastIndexOf(' ') - 1);

	}
}
