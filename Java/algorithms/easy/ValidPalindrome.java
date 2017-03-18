package easy;

public class ValidPalindrome {
	/*
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * For example, "A man, a plan, a canal: Panama" is a palindrome.
	 * "race a car" is not a palindrome.
	 * 
	 * Note: Have you consider that the string might be empty? This is a good
	 * question to ask during an interview.
	 * 
	 * For the purpose of this problem, we define empty string as valid
	 * palindrome.
	 */

	public boolean solution(String s) {
		// Your runtime beats 61.43% of java submissions. Runtime 9ms
		int start = 0, end = s.length() - 1;
		while (start < end) {
			if (!Character.isLetterOrDigit(s.charAt(start)))
				start++;
			else if (!Character.isLetterOrDigit(s.charAt(end))) {
				end--;
			} else if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
				return false;
			else {
				start++;
				end--;
			}
		}
		return true;
	}
}
