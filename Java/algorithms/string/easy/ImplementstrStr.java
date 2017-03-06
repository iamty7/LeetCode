package string.easy;

public class ImplementstrStr {
	/*
	 * Implement strStr().
	 * 
	 */

	public int solution(String haystack, String needle) {
		// Your runtime beats 93.85% of java submissions. Runtime 6ms
		return haystack.indexOf(needle);
	}

	public int solution2(String haystack, String needle) {
		// Your runtime beats 18.47% of java submissions. Runtime 15ms
		int index = -1;

		MainLoop: for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
			for (int j = 0; j < needle.length(); j++)
				if (haystack.charAt(i + j) != needle.charAt(j))
					continue MainLoop;
			index = i;
			break;
		}

		return index;
	}
}
