package hashTable.easy;

public class ValidAnagram {
	/*
	 * Given two strings s and t, write a function to determine if t is an
	 * anagram of s.
	 * 
	 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t =
	 * "car", return false.
	 * 
	 * Note: You may assume the string contains only lowercase alphabets.
	 * 
	 * Follow up: What if the inputs contain unicode characters? How would you
	 * adapt your solution to such case?
	 */

	public boolean solution(String s, String t) {
		// Your runtime beats 96.29% of java submissions. Runtime 3ms
		if (s.length() != t.length())
			return false;
		int[] chars = new int['z' - 'a' + 1];
		// Array can be used when types of char are limited e.g. alphebet.
		// Otherwise we can use map instead

		for (char c : s.toCharArray()) {
			chars[c - 'a']++;
		}

		for (char c : t.toCharArray()) {
			chars[c - 'a']--;
			if (chars[c - 'a'] < 0)
				return false;
		}

		for (int n : chars) {
			if (n != 0)
				return false;
		}

		return true;
	}
}
