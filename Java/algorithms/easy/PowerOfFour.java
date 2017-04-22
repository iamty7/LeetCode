package easy;

public class PowerOfFour {
	/*
	 * Given an integer (signed 32 bits), write a function to check whether it
	 * is a power of 4.
	 * 
	 * Example: Given num = 16, return true. Given num = 5, return false.
	 * 
	 * Follow up: Could you solve it without loops/recursion?
	 */

	public boolean isPowerOfFour(int num) {
		// Your runtime beats 9.06% of java submissions. Runtime 3ms
		if (num <= 0)
			return false;
		while (num >= 1 && num % 4 == 0) {
			num /= 4;
		}
		return num == 1;
	}

	public boolean isPowerOfFour2(int num) {
		// Your runtime beats 27.57% of java submissions. Runtime 2ms
		return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
	}
}
