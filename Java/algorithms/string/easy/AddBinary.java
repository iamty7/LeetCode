package string.easy;

import java.util.Arrays;

public class AddBinary {
	/*
	 * Given two binary strings, return their sum (also a binary string).
	 * 
	 * For example, a = "11" b = "1" Return "100".
	 */

	public String solution(String a, String b) {
		// Your runtime beats 98.55% of java submissions. Runtime 2ms
		int len_a = a.length();
		int len_b = b.length();

		int len_s;
		char[] sum = new char[len_a > len_b ? len_a + 1 : len_b + 1];
		for (int i = 0; i < sum.length; i++)
			sum[i] = '0';
		len_s = sum.length - 1;

		int i = len_a - 1, j = len_b - 1;
		while (i > -1 || j > -1) {
			sum[len_s] += binaryBitAdd(i > -1 ? a.charAt(i) : '0', j > -1 ? b.charAt(j) : '0');
			if (sum[len_s] > '1') {
				sum[len_s - 1]++;
				sum[len_s] -= 2;
			}
			i--;
			j--;
			len_s--;
		}
		return new String(sum, sum[0] == '1' ? 0 : 1, sum[0] == '1' ? sum.length : sum.length - 1);

	}

	public int binaryBitAdd(char a, char b) {
		if (a == '1' && b == '1')
			return 2;
		if (a == '0' && b == '0')
			return 0;
		return 1;
	}

	
	public String solution2(String a, String b) {
		// Your runtime beats 53.55% of java submissions. Runtime 4ms
		StringBuilder sb = new StringBuilder();

		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0)
				sum += a.charAt(i--) - '0';
			if (j >= 0)
				sum += b.charAt(j--) - '0';
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry == 1)
			sb.append(1);
		return sb.reverse().toString();

	}
}
