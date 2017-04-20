package easy;

public class ReverseWordsInAStringIII {
	/*
	 * Given a string, you need to reverse the order of characters in each word
	 * within a sentence while still preserving whitespace and initial word
	 * order.
	 * 
	 * Example 1: 
	 * Input: "Let's take LeetCode contest" 
	 * Output:  "s'teL ekat edoCteeL tsetnoc" 
	 * 
	 * Note: In the string, each word is separated
	 * by single space and there will not be any extra space in the string.
	 */

	public String reverseWords(String s) {
		// Your runtime beats 59.39% of java submissions. Runtime 17ms
		if (s.length() <= 1)
			return s;
		char[] chars = s.toCharArray();
		int left = 0, right = 1;
		while (right < s.length()) {
			if (chars[right] == ' ' || right == s.length() - 1) {
				int i = left, j = right == s.length() - 1 ? s.length() - 1 : right - 1;
				while (i < j) {
					char tmp = chars[i];
					chars[i] = chars[j];
					chars[j] = tmp;
					i++;
					j--;
				}
				left = right + 1;
			}
			right++;
		}
		return new String(chars);
	}
}
