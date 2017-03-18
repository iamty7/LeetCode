package easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Stream;

public class KeyboardRow {
	/*
	 * Given a List of words, return the words that can be typed using letters
	 * of alphabet on only one row's of American keyboard like the image below.
	 * 
	 * 
	 * American keyboard
	 * 
	 * 
	 * Example 1: Input: ["Hello", "Alaska", "Dad", "Peace"] Output: ["Alaska",
	 * "Dad"] Note: You may use one character in the keyboard more than once.
	 * You may assume the input string will only contain letters of alphabet.
	 */

	public String[] solution(String[] words) {
		// Your runtime beats 63.05% of java submissions. Runtime 4ms
		LinkedList<String> retStr = new LinkedList<>();
		int[] chars = new int['z' - 'A' + 1];
		char[] line_1 = new char[] { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'Q', 'W', 'E', 'R', 'T', 'Y',
				'U', 'I', 'O', 'P' };
		char[] line_2 = new char[] { 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'A', 'S', 'D', 'F', 'G', 'H', 'J',
				'K', 'L' };
		char[] line_3 = new char[] { 'z', 'x', 'c', 'v', 'b', 'n', 'm', 'Z', 'X', 'C', 'V', 'B', 'N', 'M' };
		for (char c : line_1)
			chars[c - 'A'] = 1;
		for (char c : line_2)
			chars[c - 'A'] = 2;
		for (char c : line_3)
			chars[c - 'A'] = 3;
		for (int i = 0; i < words.length; i++) {
			boolean flag = true;
			int line = chars[words[i].toCharArray()[0] - 'A'];
			for (char character : words[i].toCharArray()) {
				if (chars[character - 'A'] == line)
					continue;
				flag = false;
				break;
			}
			if (flag == true)
				retStr.add(words[i]);
		}

		String[] ret = new String[retStr.size()];
		int i = 0;
		for (String string : retStr) {
			ret[i] = string;
			i++;
		}

		return ret;
	}

	public String[] solution2(String[] words) {
		// !!Regex and Stream
		// Your runtime beats 3.07% of java submissions. Runtime 100ms
		return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
				.toArray(String[]::new);
	}
}
