package easy;

import java.util.LinkedList;
import java.util.List;

public class AddStrings {
	/*
	 * Given two non-negative integers num1 and num2 represented as string,
	 * return the sum of num1 and num2.
	 * 
	 * Note:
	 * 
	 * The length of both num1 and num2 is < 5100. Both num1 and num2 contains
	 * only digits 0-9. Both num1 and num2 does not contain any leading zero.
	 * You must not use any built-in BigInteger library or convert the inputs to
	 * integer directly.
	 */

	public String addStrings(String num1, String num2) {
		// Your runtime beats 26.97% of java submissions. Runtime 37ms
		if (num1.length() == 0)
			return num2;
		if (num2.length() == 0)
			return num1;
		StringBuilder sum = new StringBuilder();
		int c = 0, i = num1.length() - 1, j = num2.length() - 1;
		while (i > -1 || j > -1) {
			int bitSum = (i > -1 ? num1.charAt(i) - '0' : 0) + (j > -1 ? num2.charAt(j) - '0' : 0) + c;
			if (bitSum >= 10) {
				c = 1;
				bitSum -= 10;
			} else
				c = 0;
			sum.insert(0, bitSum);
			i--;
			j--;
		}
		if (c == 1)
			sum.insert(0, '1');
		return sum.toString();
	}
	
    public String addStrings2(String num1, String num2) {
    	// ??why reverse in the end is much faster?
    	// Your runtime beats 65.95% of java submissions. Runtime 27ms
        if (num1.length() == 0)
			return num2;
		if (num2.length() == 0)
			return num1;
		StringBuilder sum = new StringBuilder();
		int c = 0, i = num1.length() - 1, j = num2.length() - 1;
		while (i > -1 || j > -1) {
			int bitSum = (i > -1 ? num1.charAt(i) - '0' : 0) + (j > -1 ? num2.charAt(j) - '0' : 0) + c;
			if (bitSum >= 10) {
				c = 1;
				bitSum -= 10;
			}
			else 
			    c=0;
			sum.append(bitSum);
			i--;
			j--;
		}
		if (c == 1)
			sum.append('1');
		return sum.reverse().toString();
    }
}
