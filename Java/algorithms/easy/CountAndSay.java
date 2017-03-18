package easy;

public class CountAndSay {
	/*
	 * The count-and-say sequence is the sequence of integers beginning as
	 * follows: 1, 11, 21, 1211, 111221, ...
	 * 
	 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is
	 * read off as "one 2, then one 1" or 1211. Given an integer n, generate the
	 * nth sequence.
	 * 
	 * Note: The sequence of integers will be represented as a string.
	 */

	public String solution(int n) {
		// Your runtime beats 38.70% of java submissions. Runtime 8ms
		StringBuffer curr = new StringBuffer("1");
		StringBuffer prev;
		char prevChar = '1';

		for (int i = 1; i < n; i++) {
			int count = 1;
			prev = curr;
			prevChar = prev.charAt(0);
			curr = new StringBuffer();
			for (int j = 0; j < prev.length(); j++) {
				if (j == prev.length() - 1) {
					curr.append(count).append(prevChar);
					break;
				} else if (prev.charAt(j) != prev.charAt(j + 1)) {

					curr.append(count).append(prevChar);
					count = 1;
					prevChar = prev.charAt(j + 1);
				} else {
					count++;
				}
			}
		}
		return curr.toString();
	}

}
