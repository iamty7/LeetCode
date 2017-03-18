package easy;

public class SingleNumber {

	/*
	 * Given an array of integers, every element appears twice except for one.
	 * Find that single one.
	 * 
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 */
	public int solution(int[] nums) {
		// Your runtime beats 37.78% of java submissions. Runtime 1ms
		int xor = 0;

		for (int n : nums) {
			xor ^= n;
		}

		return xor;
	}
}
