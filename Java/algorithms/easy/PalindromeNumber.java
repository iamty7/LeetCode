package easy;

public class PalindromeNumber {
	/*
	 * Determine whether an integer is a palindrome. Do this without extra
	 * space.
	 */
	public boolean isPalindrome(int x) {
		// Your runtime beats 61.63% of java submissions. Runtime 216ms
		// negative number is not a palindrome number
		if (x < 0 || (x != 0 && x % 10 == 0))
			return false;
		int rev = 0;
		// half of the number to avoid overflow
		while (rev < x) {
			rev = rev * 10 + x % 10;
			x /= 10;
		}
		return x == rev || x == rev / 10;
	}
}
