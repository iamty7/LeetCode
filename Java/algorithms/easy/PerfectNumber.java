package easy;

public class PerfectNumber {
	/*
	 * We define the Perfect Number is a positive integer that is equal to the
	 * sum of all its positive divisors except itself.
	 * 
	 * Now, given an integer n, write a function that returns true when it is a
	 * perfect number and false when it is not. Example: Input: 28 Output: True
	 * Explanation: 28 = 1 + 2 + 4 + 7 + 14 Note: The input number n will not
	 * exceed 100,000,000. (1e8)
	 */

	public boolean checkPerfectNumber(int num) {
		// Runtime 14ms
		if (num == 1)
			return false;
		int sum = 1;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				sum += i;
				/*
				 * if (i != num / i) sum += num / i; 
				 * this case is guarding
				 * against the square root being adding twice which will only
				 * occur for inputs which are perfect squares (4, 9, 16, 25, 36,
				 * 49, etc.
				 * Why not adding this if still got AC??
				 */
				sum += num / i;
			}
		}
		return sum == num;
	}
}
