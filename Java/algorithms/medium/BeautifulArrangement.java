package medium;

public class BeautifulArrangement {
	/*
	 * Suppose you have N integers from 1 to N. We define a beautiful
	 * arrangement as an array that is constructed by these N numbers
	 * successfully if one of the following is true for the ith position (1 ≤ i
	 * ≤ N) in this array:
	 * 
	 * The number at the ith position is divisible by i. i is divisible by the
	 * number at the ith position. Now given N, how many beautiful arrangements
	 * can you construct?
	 * 
	 * Example 1: Input: 2 Output: 2 Explanation:
	 * 
	 * The first beautiful arrangement is [1, 2]: Number at the 1st position
	 * (i=1) is 1, and 1 is divisible by i (i=1). Number at the 2nd position
	 * (i=2) is 2, and 2 is divisible by i (i=2).
	 * 
	 * The second beautiful arrangement is [2, 1]: Number at the 1st position
	 * (i=1) is 2, and 2 is divisible by i (i=1). Number at the 2nd position
	 * (i=2) is 1, and i (i=2) is divisible by 1.
	 * 
	 * Note: N is a positive integer and will not exceed 15.
	 */

	public int countArrangement(int N) {
		// Backtracking
		// Your runtime beats 56.78% of java submissions. Runtime 99ms
		boolean[] used = new boolean[N + 1];
		return helper(N, 0, 1, used);

	}

	private int helper(int N, int cnt, int pos, boolean[] used) {
		if (pos == N + 1)
			return cnt + 1;
		for (int i = 1; i < N + 1; i++) {
			if (used[i] == true)
				continue;
			if (i % pos == 0 || pos % i == 0) {
				used[i] = true;
				cnt = helper(N, cnt, pos + 1, used);
				used[i] = false;
			}
		}
		return cnt;
	}

	public int countArrangement2(int N) {
		// !! Backtracking but starting from the end fo the array
		// Your runtime beats 91.10% of java submissions. Runtime 11ms
		boolean[] used = new boolean[N + 1];
		return helper(N, 0, N, used);

	}

	private int helper2(int N, int cnt, int pos, boolean[] used) {
		if (pos == 1)
			return cnt + 1;
		for (int i = N; i > 0; i--) {
			if (used[i] == true || (i % pos != 0 && pos % i != 0))
				continue;
			used[i] = true;
			cnt = helper(N, cnt, pos - 1, used);
			used[i] = false;
		}
		return cnt;
	}
}
