package easy;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
	/*
	 * Given a string s and a non-empty string p, find all the start indices of
	 * p's anagrams in s.
	 * 
	 * Strings consists of lowercase English letters only and the length of both
	 * strings s and p will not be larger than 20,100.
	 * 
	 * The order of output does not matter.
	 * 
	 * Example 1:
	 * 
	 * Input: s: "cbaebabacd" p: "abc"
	 * 
	 * Output: [0, 6]
	 * 
	 * Explanation: The substring with start index = 0 is "cba", which is an
	 * anagram of "abc". The substring with start index = 6 is "bac", which is
	 * an anagram of "abc". Example 2:
	 * 
	 * Input: s: "abab" p: "ab"
	 * 
	 * Output: [0, 1, 2]
	 * 
	 * Explanation: The substring with start index = 0 is "ab", which is an
	 * anagram of "ab". The substring with start index = 1 is "ba", which is an
	 * anagram of "ab". The substring with start index = 2 is "ab", which is an
	 * anagram of "ab".
	 */

	public List<Integer> solution(String s, String p) {
		// These codes work locally however output [] with input string
		// "cbaebabacd" and "abc"
		List<Integer> ret = new ArrayList<>();
		Field field;

		try {
			field = String.class.getDeclaredField("value");
			field.setAccessible(true);

			char[] charsS = (char[]) field.get(s);
			int lenS = charsS.length;

			Map<Character, Integer> mapP = new HashMap<>();

			for (int i = 0; i < p.length(); i++) {
				mapP.put(p.charAt(i), 1);
			}

			for (int i = 0; i < lenS; i++) {
				if (mapP.containsKey(charsS[i])) {
					mapP.put(charsS[i], 0);
					boolean flag = true;
					for (int j = 1; j < p.length(); j++) {
						if (i + j >= lenS) {
							flag = false;
							break;
						}

						if (mapP.containsKey(charsS[i + j]))
							if (mapP.get(charsS[i + j]) == 1) {
								mapP.put(charsS[i + j], 0);
								continue;
							}
						flag = false;
						break;

					}
					if (flag == true)
						ret.add(i);
					for (char k : mapP.keySet()) {
						mapP.put(k, 1);
					}

				}

			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return ret;
	}

	public List<Integer> solution2(String s, String p) {
		// !! Sliding Window Solution. 
		// ??How strings are stored in memory? Are they just made up of chars?
		// Your runtime beats 71.41% of java submissions. Runtime 22ms
		List<Integer> list = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0)
			return list;

		int[] hash = new int[256]; // character hash

		// record each character in p to hash
		for (char c : p.toCharArray()) {
			hash[c]++;
		}
		// two points, initialize count to p's length
		int left = 0, right = 0, count = p.length();

		while (right < s.length()) {
			// move right everytime, if the character exists in p's hash,
			// decrease the count
			// current hash value >= 1 means the character is existing in p
			if (hash[s.charAt(right)] >= 1) {
				count--;
			}
			hash[s.charAt(right)]--;
			right++;

			// when the count is down to 0, means we found the right anagram
			// then add window's left to result list
			if (count == 0) {
				list.add(left);
			}
			// if we find the window's size equals to p, then we have to move
			// left (narrow the window) to find the new match window
			// ++ to reset the hash because we kicked out the left
			// only increase the count if the character is in p
			// the count >= 0 indicate it was original in the hash, cuz it won't
			// go below 0
			if (right - left == p.length()) {

				if (hash[s.charAt(left)] >= 0) {
					count++;
				}
				hash[s.charAt(left)]++;
				left++;
//				right = left;
			}

		}
		return list;
	}

}
