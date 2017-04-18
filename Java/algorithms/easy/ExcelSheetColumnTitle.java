package easy;

public class ExcelSheetColumnTitle {
	/*
	 * Given a positive integer, return its corresponding column title as appear
	 * in an Excel sheet.
	 * 
	 * For example: 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
	 */
	public String convertToTitle(int n) {
		// Your runtime beats 12.61% of java submissions. Runtime 0ms
		int a, b;
		a = n;
		b = n % 26;
		StringBuilder sb = new StringBuilder();
		while (a != 0 || b != 0) {
			if (b == 0) {
				b = 26;
				a--;
			}
			sb.insert(0, (char) (b - 1 + 'A'));
			a = a / 26;
			b = a % 26;
		}
		return sb.toString();
	}
}
