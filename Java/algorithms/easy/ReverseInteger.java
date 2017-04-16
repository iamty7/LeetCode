package easy;

public class ReverseInteger {
	/*
	 * Reverse digits of an integer.
	 * 
	 * Example1: x = 123, return 321 Example2: x = -123, return -321
	 * 
	 * Note: The input is assumed to be a 32-bit signed integer. Your function
	 * should return 0 when the reversed integer overflows.
	 */
	public int reverse(int x) {
		// Your runtime beats 34.05% of java submissions. Runtime 48ms
		int rev = 0, preRev = 0;
		int inputX = Math.abs(x);
		while (inputX > 0) {
			if ((Integer.MAX_VALUE - inputX % 10) / 10 < rev)
				return 0;
			else {
				rev = rev * 10 + inputX % 10;
				inputX /= 10;
				preRev = rev;
			}
		}
		return x > 0 ? rev : -rev;
	}

	public int reverse2(int x) {
		// In Java -123%10=-3 however google said -123%10=7
		// Your runtime beats 45.49% of java submissions. Runtime 45ms
		long result = 0;
		while (x != 0) {
			result = (result * 10) + (x % 10);
			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
				return 0;
			x = x / 10;
		}
		return (int) result;
	}
}
