package easy;

public class PowerOfThree {
	/*
	 * Given an integer, write a function to determine if it is a power of
	 * three.
	 * 
	 * Follow up: Could you do it without using any loop / recursion?
	 */

	public boolean isPowerOfThree(int n) {
		// Your runtime beats 39.07% of java submissions. Runtime 20ms
		if (n == 0)
			return false;
		if (n == 1)
			return true;
		if (n % 3 == 0)
			return isPowerOfThree(n / 3);
		else
			return false;
	}

	public boolean isPowerOfThree2(int n) {
		return (n > 0 && 1162261467 % n == 0);
	}
}
