package easy;

public class PowerOfTwo {
	/*
	 * Given an integer, write a function to determine if it is a power of two.
	 * 
	 */

	public boolean isPowerOfTwo(int n) {
		// Your runtime beats 25.04% of java submissions. Runtime 2ms
		while (n != 1) {
			if (n % 2 != 0)
				return false;
			n /= 2;
		}
		return true;
	}

	public boolean isPowerOfTwo2(int n) {
		// !!Power of 2 means only one bit of n is '1', so use the trick n&(n-1)==0 to judge whether that is the case
		// Your runtime beats 25.04% of java submissions. Runtime 2ms
		if (n <= 0)
			return false;
		if ((n & (n - 1)) == 0)
			return false;
		else
			return true;
	}
	
	public boolean isPowerOfTwo3(int n) {
		// Your runtime beats 3.09% of java submissions. Runtime 4ms
        return n>0 && Integer.bitCount(n) == 1;
    }
}
