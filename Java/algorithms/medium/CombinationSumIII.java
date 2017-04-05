package medium;

import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
	/*
	 * Find all possible combinations of k numbers that add up to a number n,
	 * given that only numbers from 1 to 9 can be used and each combination
	 * should be a unique set of numbers.
	 * 
	 * Example 1: Input: k = 3, n = 7 Output: [[1,2,4]]
	 * 
	 * Example 2: Input: k = 3, n = 9 Output: [[1,2,6], [1,3,5], [2,3,4]]
	 */
	public List<List<Integer>> solution(int k, int n) {
		// Your runtime beats 5.41% of java submissions. Runtime 3ms
		List<List<Integer>> list = new LinkedList<>();
		if (n < 1 || n > 45 || k > 9)
			return list;
		backtracing(list, new LinkedList(), k, n, 1);
		return list;
	}

	private void backtracing(List<List<Integer>> list, List<Integer> tempList, int k, int n, int start) {
		if (n == 0 && k == 0) {
			list.add(new LinkedList<>(tempList));
			return;
		}
		if (k == 0)
			return;
		for (int i = start; i < 10; i++) {
			tempList.add(i);
			backtracing(list, tempList, k - 1, n - i, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
}
