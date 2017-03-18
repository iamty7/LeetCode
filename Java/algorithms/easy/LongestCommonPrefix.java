package easy;

import java.util.Arrays;

public class LongestCommonPrefix {
	/*
	 * Write a function to find the longest common prefix string amongst an
	 * array of strings.
	 */

	public String solution(String[] strs) {
		// Your runtime beats 71.02% of java submissions. Runtime 11ms
		if (strs.length == 0)
			return "";

		int prefix_len = 0;
		int min_len = strs[0].length();
		for (int i = 1; i < strs.length; i++) {
			if (strs[i].length() < min_len)
				min_len = strs[i].length();
		}

		if (min_len == 0)
			return "";

		mainloop: while (true) {
			char c = strs[0].charAt(prefix_len);
			for (int i = 0; i < strs.length; i++) {
				if (strs[i].charAt(prefix_len) != c) {
					break mainloop;
				}
			}
			prefix_len++;
			if (prefix_len == min_len)
				break mainloop;
		}

		char[] retStr = new char[prefix_len];
		for (int j = 0; j < prefix_len; j++)
			retStr[j] = strs[0].charAt(j);
		return new String(retStr);

	}

	public String solution2(String[] strs) {
		// Your runtime beats 21.45% of java submissions. Runtime 15ms
		if (strs == null || strs.length == 0)
			return "";

		StringBuffer sBuffer = new StringBuffer();

		Arrays.sort(strs);

		String aString = strs[0];
		String bString = strs[strs.length - 1];

		for (int i = 0; i < aString.length(); i++)
			if (aString.charAt(i) == bString.charAt(i))
				sBuffer.append(aString.charAt(i));
			else
				break;

		return sBuffer.toString();
	}

}
