package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {
	/*
	 * Given a string, sort it in decreasing order based on the frequency of
	 * characters.
	 * 
	 * Example 1:
	 * 
	 * Input: "tree"
	 * 
	 * Output: "eert"
	 * 
	 * Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e'
	 * must appear before both 'r' and 't'. Therefore "eetr" is also a valid
	 * answer. Example 2:
	 * 
	 * Input: "cccaaa"
	 * 
	 * Output: "cccaaa"
	 * 
	 * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a
	 * valid answer. Note that "cacaca" is incorrect, as the same characters
	 * must be together. Example 3:
	 * 
	 * Input: "Aabb"
	 * 
	 * Output: "bbAa"
	 * 
	 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect. Note
	 * that 'A' and 'a' are treated as two different characters.
	 */

	public String frequencySort(String s) {
		// Your runtime beats 90.79% of java submissions. Runtime 15ms
		int[] freqTable = new int[256];
		// Here you can use TreeMap to sort automatically
		Map<Integer, List<Character>> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			freqTable[s.charAt(i)]++;
		}
		for (int i = 0; i < 256; i++) {
			if (freqTable[i] != 0) {
				if (!map.containsKey(freqTable[i]))
					map.put(freqTable[i], new LinkedList<>());
				List<Character> list = map.get(freqTable[i]);
				list.add((char) (i));
			}
		}
		Arrays.sort(freqTable);
		StringBuilder sb = new StringBuilder();
		for (int i = 255; i > -1; i--) {
			if (freqTable[i] == 0)
				continue;
			for (int j = 0; j < map.get(freqTable[i]).size(); j++) {
				char c = map.get(freqTable[i]).get(j);
				for (int k = freqTable[i]; k > 0; k--) {
					sb.append(c);
				}
			}
			while (i - 1 > -1 && freqTable[i - 1] == freqTable[i])
				i--;
		}
		return sb.toString();
	}
}
