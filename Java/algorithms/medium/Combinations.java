package medium;

import java.util.LinkedList;
import java.util.List;

public class Combinations {
	/*
	 * Given two integers n and k, return all possible combinations of k numbers
	 * out of 1 ... n.
	 * 
	 * For example, If n = 4 and k = 2, a solution is:
	 * 
	 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
	 */

	public List<List<Integer>> combine(int n, int k) {
		// Your runtime beats 47.06% of java submissions. Runtime 34ms
		List<List<Integer>> list = new LinkedList<>();
		helper(list, n, k, 0, 1, new LinkedList<>());
		return list;
	}

	private void helper(List<List<Integer>> list, int n, int k, int cnt, int i, LinkedList tmpList) {
		if (cnt == k)
			list.add(new LinkedList<>(tmpList));
		else if (i > n) {
			return;
		} else {
			tmpList.add(i);
			helper(list, n, k, cnt + 1, i + 1, tmpList);
			tmpList.removeLast();
			helper(list, n, k, cnt, i + 1, tmpList);
		}
	}
}
