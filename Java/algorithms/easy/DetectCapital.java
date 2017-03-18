package easy;

public class DetectCapital {
	/*
	 * Given a word, you need to judge whether the usage of capitals in it is
	 * right or not.
	 * 
	 * We define the usage of capitals in a word to be right when one of the
	 * following cases holds:
	 * 
	 * All letters in this word are capitals, like "USA". 
	 * All letters in this word are not capitals, like "leetcode". Only the first 
	 * letter in this word is capital if it has more than one letter, like "Google". 
	 * Otherwise, we define that this word doesn't use capitals in a right way. 
	 * Example 1: Input: "USA" Output: True 
	 * Example 2: Input: "FlaG" Output: False Note:
	 * The input will be a non-empty word consisting of uppercase and lowercase
	 * latin letters.
	 */

	public boolean solution(String word) {
		// Your runtime beats 18.35% of java submissions. Runtime 47ms
		if (word.length() == 1)
			return true;

		if (word.charAt(0) >= 'a')
			for (int i = 1; i < word.length(); i++) {
				if (word.charAt(i) < 'a')
					return false;
			}
		else {
			if (word.charAt(1) >= 'a')
				for (int i = 2; i < word.length(); i++) {
					if (word.charAt(i) < 'a')
						return false;
				}
			else
				for (int i = 2; i < word.length(); i++) {
					if (word.charAt(i) >= 'a')
						return false;
				}
		}

		return true;
	}

	public boolean solution2(String word) {
		// !!regex
		// Your runtime beats 11.61% of java submissions. Runtime 52ms
		return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]*");

	}

	public boolean solution3(String word) {
		// !!
		// Your runtime beats 33.30% of java submissions. Runtime 33ms
		int cnt = 0;
		for (char c : word.toCharArray())
			if (c < 'a')
				cnt++;

		return ((cnt == 1 && word.charAt(0) < 'a') || cnt == 0 || cnt == word.length());
	}

}
