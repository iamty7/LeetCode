package easy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.security.util.Length;

public class NumberOfSegmentsInAString {
	/*
	 * Count the number of segments in a string, where a segment is defined to
	 * be a contiguous sequence of non-space characters.
	 * 
	 * Please note that the string does not contain any non-printable
	 * characters.
	 * 
	 * Example:
	 * 
	 * Input: "Hello, my name is John" Output: 5
	 */

	public int solution(String s) {
		// Your runtime beats 3.74% of java submissions. Runtime 7ms
		Pattern pattern = Pattern.compile("\\S+");
		Matcher matcher = pattern.matcher(s);
		int ret = 0;
		while (matcher.find())
			ret++;
		return ret;
	}

	public int solution2(String s) {
		// Your runtime beats 35.08% of java submissions. Runtime 3ms
		int ret = 0;
		boolean flag = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ')
				flag = true;

			else {
				if (flag == true) {
					ret++;
					flag = false;
				}

			}
		}
		if (s.length() != 0)
			if (s.charAt(s.length() - 1) != ' ')
				ret++;
		return ret;
	}
}
