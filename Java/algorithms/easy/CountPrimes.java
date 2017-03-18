package easy;

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
		// !!
		// Your runtime beats 45.39% of java submissions. Runtime 34ms
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

	public int solution3(int n) {
		// !!!Very Fast Method!
		// Your runtime beats 97.82% of java submissions. Runtime 14ms
		if (n < 3)
			return 0;
		/*
		 * Start with the assumption that half the numbers below n are prime
		 * candidates, since we know that half of them are even, and so _in
		 * general_ aren't prime.
		 * 
		 * An exception to this is 2, which is the only even prime. But also 1
		 * is an odd which isn't prime. These two exceptions (a prime even and a
		 * for-sure not-prime odd) cancel each other out for n > 2, so our
		 * assumption holds.
		 * 
		 * We'll decrement count when we find an odd which isn't prime.
		 *
		 * If n = 3, c = 1. If n = 5, c = 2. If n = 10, c = 5.
		 */
		int count = n / 2;

		/*
		 * Java initializes boolean arrays to {false}. In this method, we'll use
		 * truth to mark _composite_ numbers.
		 * 
		 * This is the opposite of most Sieve of Eratosthenes methods, which use
		 * truth to mark _prime_ numbers.
		 * 
		 * We will _NOT_ mark evens as composite, even though they are. This is
		 * because `c` is current after each `i` iteration below.
		 */
		boolean[] f = new boolean[n]; // boolean[] are initialed as false by
										// default
		/*
		 * Starting with an odd prime-candidate above 2, increment by two to
		 * skip evens (which we know are not prime candidates).
		 */
		for (int i = 3; i * i < n; i += 2) {
			if (f[i])
				// c has already been decremented for this composite odd
				continue;
			/*
			 * For each prime i, iterate through the odd composites we know we
			 * can form from i, and mark them as composite if not already
			 * marked.
			 * 
			 * We know that i * i is composite. We also know that i * i + i is
			 * composite, since they share a common factor of i. Thus, we also
			 * know that i * i + a*i is composite for all real a, since they
			 * share a common factor of i.
			 * 
			 * Note, though, that i * i + i _must_ be composite for an
			 * independent reason: it must be even. (all i are odd, thus all i*i
			 * are odd, thus all (odd + odd) are even).
			 * 
			 * Recall that, by initializing c to n/2, we already accounted for
			 * all of the evens less than n being composite, and so marking i *
			 * i + (odd)*i as composite is needless bookkeeping.
			 * 
			 * So, we can skip checking i * i + a*i for all odd a, and just
			 * increment j by even multiples of i, since all (odd + even) are
			 * odd.
			 */
			for (int j = i * i; j < n; j += 2 * i) {
				// j starts from i*i instead of i because (1 to i)*i has been
				// dealt with in previous loops
				if (!f[j]) {
					--count;
					f[j] = true;
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
