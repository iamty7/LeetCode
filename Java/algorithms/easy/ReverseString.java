package easy;

public class ReverseString {
	/*
	 * Write a function that takes a string as input and returns the string
	 * reversed.
	 * 
	 * Example: Given s = "hello", return "olleh".
	 */

	public String solution(String s) {
		char[] chars = s.toCharArray();
		int start = 0, end = chars.length-1;
		while (start < end) {
			char tmp = chars[start];
			chars[start] = chars[end];
			chars[end] = tmp;
			start++;
			end--;
		}
		return new String(chars);
	}
}
