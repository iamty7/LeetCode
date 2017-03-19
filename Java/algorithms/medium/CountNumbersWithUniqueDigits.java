package medium;

public class CountNumbersWithUniqueDigits {
	/*
	 * Given a non-negative integer n, count all numbers with unique digits, x,
	 * where 0 ≤ x < 10n.
	 * 
	 * Example: Given n = 2, return 91. (The answer should be the total numbers
	 * in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
	 */

	public int countNumbersWithUniqueDigits(int n) {
		// Your runtime beats 12.35% of java submissions. runtime 0ms
		int ret = 0;

		for (int i = 1; i < n + 1; i++) {
			int availableNum = 9;
			int subRet = 9;
			for (int j = 1; j < i; j++)
				subRet *= availableNum--;
			ret += subRet;
		}
		return ret + 1;// 1 for 0
	}
}
