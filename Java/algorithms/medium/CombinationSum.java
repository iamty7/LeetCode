package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CombinationSum {
	/*
	 * Given a set of candidate numbers (C) (without duplicates) and a target
	 * number (T), find all unique combinations in C where the candidate numbers
	 * sums to T.
	 * 
	 * The same repeated number may be chosen from C unlimited number of times.
	 * 
	 * Note: All numbers (including target) will be positive integers. The
	 * solution set must not contain duplicate combinations. For example, given
	 * candidate set [2, 3, 6, 7] and target 7, A solution set is: [ [7], [2, 2,
	 * 3] ]
	 */

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		// Backtracing
		// Your runtime beats 36.10% of java submissions. Runtime 27ms
		Arrays.sort(candidates);
		List<List<Integer>> list = new LinkedList<>();
		backtracing(list, new LinkedList<>(), target, candidates, 0);
		return list;
	}

	private void backtracing(List<List<Integer>> list, LinkedList tempList, int target, int[] candidates, int start) {
		if (target < 0)
			return;
		else if (target == 0)
			list.add(new LinkedList<>(tempList));
		else {
			for (int i = start; i < candidates.length; i++) {
				tempList.add(candidates[i]);
				backtracing(list, tempList, target - candidates[i], candidates, i);
				tempList.removeLast();
			}
		}
	}
}
