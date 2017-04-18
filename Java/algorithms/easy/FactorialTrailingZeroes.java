package easy;

public class FactorialTrailingZeroes {
	/*
	 * Given an integer n, return the number of trailing zeroes in n!.
	 * 
	 * Note: Your solution should be in logarithmic time complexity.
	 */
	public int trailingZeroes(int n) {
		// !!
		// Your runtime beats 46.30% of java submissions. Runtime 1ms
		if (n == 0)
			return 0;
		return n / 5 + trailingZeroes(n / 5);
	}

}
