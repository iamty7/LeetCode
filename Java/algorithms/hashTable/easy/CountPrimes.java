package hashTable.easy;

public class CountPrimes {
	/*
	 * Description:
	 * 
	 * Count the number of prime numbers less than a non-negative number, n.
	 */

	public int solution(int n) {
		// Your runtime beats 1.61% of java submissions. Runtime 454ms

		int primeCnt = 0;
		int[] nums = new int[n];
		for (int i = 2; i < n; i++)
			nums[i] = i;

		for (int i = 2; i < n; i++) {
			if (nums[i] == -1)
				continue;
			if (!isPrime(nums[i]))
				nums[i] = -1;
			else {
				primeCnt++;
				for (int j = 2 * i; j < n; j += i)
					nums[j] = -1; // Non-prime numbers are set to be -1
			}

		}

		return primeCnt;
	}

	public int solution2(int n) {
		boolean[] notPrime = new boolean[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (notPrime[i] == false) {
				count++;
				for (int j = 2; i * j < n; j++) {
					notPrime[i * j] = true;
				}
			}
		}

		return count;
	}

	public boolean isPrime(int n) {
		if (n == 1)
			return false;
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;

		for (int i = 3; i * i < n; i += 2)
			if (n % i == 0)
				return false;

		return true;
	}
}
