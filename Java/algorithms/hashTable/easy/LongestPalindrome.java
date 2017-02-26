package hashTable.easy;

import java.util.HashSet;

public class LongestPalindrome {
	/*
	 * Given a string which consists of lowercase or uppercase letters, find the
	 * length of the longest palindromes that can be built with those letters.
	 * 
	 * This is case sensitive, for example "Aa" is not considered a palindrome
	 * here.
	 * 
	 * Note: Assume the length of given string will not exceed 1,010.
	 * 
	 * Example:
	 * 
	 * Input: "abccccdd"
	 * 
	 * Output: 7
	 * 
	 * Explanation: One longest palindrome that can be built is "dccaccd", whose
	 * length is 7.
	 */

	public int solution(String s) {
		// Your runtime beats 65.69% of java submissions. Runtime 15ms
		int ret = 0;
		int[] chars = new int[128]; // the dimension of the array can be even
									// smaller since there are only 26*2=52
									// characters
		for (int i = 0; i < s.length(); i++) {
			chars[s.charAt(i)]++;
		}

		boolean flag = false;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] % 2 == 1)
				flag = true;
			ret += chars[i] / 2;
		}
		ret *= 2;
		if (flag == true)
			++ret;

		return ret;
	}

	public int solution2(String s) {
		// Basically same with the last one
		// Your runtime beats 13.85% of java submissions. Runtime 28ms
		int ret = 0;
		int[] charCnt = new int[128];
		HashSet<Character> chars = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			charCnt[s.charAt(i)]++;
			chars.add(s.charAt(i));
		}

		boolean flag = false;
		for (char c : chars) {
			if (charCnt[c] % 2 == 1)
				flag = true;
			ret += charCnt[c] / 2;
		}
		ret *= 2;
		if (flag == true)
			++ret;

		return ret;
	}

	public int solution3(String s) {
		// Your runtime beats 21.19% of java submissions. Runtime 26ms
		if (s == null || s.length() == 0)
			return 0;
		HashSet<Character> hs = new HashSet<Character>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (hs.contains(s.charAt(i))) {
				hs.remove(s.charAt(i));
				count++;
			} else {
				hs.add(s.charAt(i));
			}
		}
		if (!hs.isEmpty())
			return count * 2 + 1;
		return count * 2;
	}

}
