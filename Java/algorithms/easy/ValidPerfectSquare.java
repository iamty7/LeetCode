package easy;

public class ValidPerfectSquare {
	/*
	 * Given a positive integer num, write a function which returns True if num
	 * is a perfect square else False.
	 * 
	 * Note: Do not use any built-in library function such as sqrt.
	 * 
	 * Example 1:Input: 16 Returns: True Example 2: Input: 14 Returns: False
	 */

	public boolean isPerfectSquare(int num) {
		// A square number equals 1+3+5+7+...
		// Your runtime beats 22.97% of java submissions. Runtime 1ms
		int i = 1;
		while (num > 0) {
			num -= i;
			i += 2;
		}
		return num == 0;
	}

	public boolean isPerfectSquare2(int num) {
		// Your runtime beats 41.75% of java submissions. Runtime 0ms
		long low = 1, high = num;
		while (low <= high) {
			long mid = (low + high) >>> 1;
			if (mid * mid == num) {
				return true;
			} else if (mid * mid < num) {
				low = (int) mid + 1;
			} else {
				high = (int) mid - 1;
			}
		}
		return false;
	}

	public boolean isPerfectSquare3(int num) {
		// !!Newton Method
		// Your runtime beats 41.75% of java submissions. Runtime 0ms
		long x = num;
		while (x * x > num) {
			x = (x + num / x) >> 1;
		}
		return x * x == num;
	}
}
