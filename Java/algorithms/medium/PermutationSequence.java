package medium;

import java.util.LinkedList;
import java.util.List;

public class PermutationSequence {
	/*
	 * The set [1,2,3,…,n] contains a total of n! unique permutations.
	 * 
	 * By listing and labeling all of the permutations in order, We get the
	 * following sequence (ie, for n = 3):
	 * 
	 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth
	 * permutation sequence.
	 * 
	 * Note: Given n will be between 1 and 9 inclusive.
	 */

	public String getPermutation(int n, int k) {
		// Your runtime beats 36.19% of java submissions. Runtime 19ms
		k--;
		List<Character> list = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			list.add((char) (i + 48));
		}
		int tmp = 1, j = 1;
		while (tmp <= k) {
			tmp *= ++j;
		}
		while (k != 0) {
			while (tmp > k) {
				tmp /= j--;
			}
			int offset = k / tmp;
			k %= tmp;
			helper(list, list.size() - 1 - j, offset);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		return new String(sb);
	}

	private void helper(List<Character> list, int left, int offset) {
		char tmp = list.get(left + offset);
		list.remove(left + offset);
		list.add(left, tmp);
	}
}
