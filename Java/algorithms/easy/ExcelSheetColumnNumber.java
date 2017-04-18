package easy;

public class ExcelSheetColumnNumber {
	/*
	 * Related to question Excel Sheet Column Title
	 * 
	 * Given a column title as appear in an Excel sheet, return its
	 * corresponding column number.
	 * 
	 * For example: A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
	 */

	public int titleToNumber(String s) {
		// Your runtime beats 56.81% of java submissions. Runtime 2ms
		int num = 0;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			num *= 26;
			num += chars[i] - 'A' + 1;
		}
		return num;
	}
}
