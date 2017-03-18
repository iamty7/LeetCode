package easy;

import java.util.HashMap;

public class IsomorphicStrings {
	/*
	 * Given two strings s and t, determine if they are isomorphic.
	 * 
	 * Two strings are isomorphic if the characters in s can be replaced to get
	 * t.
	 * 
	 * All occurrences of a character must be replaced with another character
	 * while preserving the order of characters. No two characters may map to
	 * the same character but a character may map to itself.
	 * 
	 * For example, Given "egg", "add", return true.
	 * 
	 * Given "foo", "bar", return false.
	 * 
	 * Given "paper", "title", return true.
	 * 
	 * Note: You may assume both s and t have the same length.
	 */

	public boolean solution(String s, String t) {
		// !!
		// HashMap<Character, Integer> indexS = new HashMap<>();
		// HashMap<Character, Integer> indexT = new HashMap<>();
		// // Can not use the method in "Word Pattern" without modification
		// because
		// // here are char to char instead of char to word
		// for (int i = 0; i < s.length(); i++) {
		// if (indexS.put(s.charAt(i), i) != indexT.put(t.charAt(i), i)){
		//// for(int j=0;j<=i;j++)
		//// System.out.print(s.charAt(j));
		//// System.out.println();
		//// for(int j=0;j<=i;j++)
		//// System.out.print(t.charAt(j));
		// return false;
		// }
		//
		// }

		// Your runtime beats 31.83% of java submissions. Runtime 25ms
		HashMap<Character, Character> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				if (!map.get(s.charAt(i)).equals(t.charAt(i)))
					return false;
			} else {
				if (map.containsValue(t.charAt(i)))
					return false;
				map.put(s.charAt(i), t.charAt(i));
			}
		}

		return true;
	}

	public boolean solution2(String s, String t) {

		// Your runtime beats 40.82% of java submissions. Runtime 22ms
		HashMap<Character, Character> s2t = new HashMap<>();
		HashMap<Character, Character> t2s = new HashMap<>();
		// Use two map to search value SILGHTLY faster compared to Method 1
		for (int i = 0; i < s.length(); i++) {
			if (s2t.containsKey(s.charAt(i))) {
				if (!s2t.get(s.charAt(i)).equals(t.charAt(i)))
					return false;
			} else {
				if (t2s.containsKey(t.charAt(i)))
					return false;
				s2t.put(s.charAt(i), t.charAt(i));
				t2s.put(t.charAt(i), s.charAt(i));
			}
		}

		return true;
	}

	public boolean solution3(String s, String t) {
		// !!Use Array to speed up the search process
		// Your runtime beats 70.76% of java submissions. Runtime 12ms
		int[] m1 = new int[256], m2 = new int[256];
		int n = s.length();
		for (int i = 0; i < n; ++i) {
			if (m1[s.charAt(i)] != m2[t.charAt(i)])
				return false;
			m1[s.charAt(i)] = i + 1;
			m2[t.charAt(i)] = i + 1;
		}
		return true;
	}
}
