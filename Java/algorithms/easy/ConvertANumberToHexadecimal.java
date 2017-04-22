package easy;

public class ConvertANumberToHexadecimal {
	/*
	 * Given an integer, write an algorithm to convert it to hexadecimal. For
	 * negative integer, two’s complement method is used.
	 * 
	 * Note: All letters in hexadecimal (a-f) must be in lowercase. The
	 * hexadecimal string must not contain extra leading 0s. If the number is
	 * zero, it is represented by a single zero character '0'; otherwise, the
	 * first character in the hexadecimal string will not be the zero character.
	 * The given number is guaranteed to fit within the range of a 32-bit signed
	 * integer. You must not use any method provided by the library which
	 * converts/formats the number to hex directly.
	 * 
	 * Example 1: Input: 26 Output: "1a"
	 * 
	 * Example 2: Input: -1 Output: "ffffffff"
	 */

	public String toHex(int num) {
		// Your runtime beats 56.86% of java submissions. Runtime 8ms
		int[] map = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			sb.insert(0, (char) map[(num & 15)]);
			num >>>= 4;
		}
		return num == 0 ? "0" : sb.toString();
	}
}
