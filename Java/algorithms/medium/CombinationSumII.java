package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
	/*
	 * Given a collection of candidate numbers (C) and a target number (T), find
	 * all unique combinations in C where the candidate numbers sums to T.
	 * 
	 * Each number in C may only be used once in the combination.
	 * 
	 * Note: All numbers (including target) will be positive integers. The
	 * solution set must not contain duplicate combinations. 
	 * 
	 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, A solution set is: [
	 * [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] ]
	 */

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		// Your runtime beats 62.63% of java submissions. Runtime 23ms
		List<List<Integer>> list = new LinkedList<>();
		Arrays.sort(candidates);
		backtracing(list, new LinkedList<>(), candidates, target, 0);
		return list;
	}

	private void backtracing(List<List<Integer>> list, LinkedList tempList, int[] candidates, int target, int start) {
		if (target < 0 || start == candidates.length)
			return;
		else if (target == 0)
			list.add(new LinkedList<>(tempList));
		else
			for (int i = start; i < candidates.length; i++) {
				tempList.add(candidates[i]);
				backtracing(list, tempList, candidates, target - candidates[i], i + 1);
				tempList.removeLast();
				while (i + 1 < candidates.length && candidates[i + 1] == candidates[i])
					i++;
			}
	}
}
