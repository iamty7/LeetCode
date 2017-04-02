package medium;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
	/*
	 * Given a collection of distinct numbers, return all possible permutations.
	 * 
	 * For example, [1,2,3] have the following permutations: [ [1,2,3], [1,3,2],
	 * [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
	 */

	public List<List<Integer>> permute(int[] nums) {
		// Backtracing
		// Your runtime beats 15.18% of java submissions. Runtime 10ms
		List<List<Integer>> list = new LinkedList<>();
		backtracing(list, new LinkedList<>(), nums);
		return list;
	}

	private void backtracing(List<List<Integer>> list, LinkedList subList, int[] nums) {
		if (subList.size() == nums.length)
			list.add(new LinkedList<>(subList));
		else
			for (int i = 0; i < nums.length; i++) {
				if (subList.contains(nums[i]))
					continue;
				subList.add(nums[i]);
				backtracing(list, subList, nums);
				subList.remove(subList.size() - 1);
			}
	}
}
