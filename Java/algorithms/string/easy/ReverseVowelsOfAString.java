package string.easy;

public class ReverseVowelsOfAString {
	/*
	 * Write a function that takes a string as input and reverse only the vowels
	 * of a string.
	 * 
	 * Example 1: Given s = "hello", return "holle".
	 * 
	 * Example 2: Given s = "leetcode", return "leotcede".
	 * 
	 * Note: The vowels does not include the letter "y".
	 */

	public String solution(String s) {
		// Your runtime beats 86.53% of java submissions. Runtime 5ms
		if (s.length() == 0 || s.length() == 1)
			return s;

		char[] retStr = s.toCharArray();

		int i = 0, j = retStr.length - 1;

		while (true) {
			while (i < retStr.length)
				if (!isVowel(retStr[i]))
					i++;
				else
					break;
			while (j > -1)
				if (!isVowel(retStr[j]))
					j--;
				else
					break;
			if (i >= j)
				return new String(retStr);
			char tmp = retStr[i];
			retStr[i] = retStr[j];
			retStr[j] = tmp;
			i++;
			j--;
		}

	}

	private boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
			return true;
		else
			return false;
	}
}
