package medium;

import java.util.LinkedList;
import java.util.List;

public class Subsets {
	/*
	 * Given a set of distinct integers, nums, return all possible subsets.
	 * 
	 * Note: The solution set must not contain duplicate subsets.
	 * 
	 * For example, If nums = [1,2,3], a solution is:
	 * 
	 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
	 */

	public List<List<Integer>> subsets(int[] nums) {
		// Your runtime beats 36.04% of java submissions. Runtime 2ms
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		int times = (int) Math.pow(2, nums.length) - 1;

		while (times >= 0) {
			List<Integer> subList = new LinkedList<>();
			for (int i = 0; i < nums.length; i++) {
				if ((times >> i) % 2 == 1)
					subList.add(nums[i]);
			}
			list.add(subList);
			times--;
		}
		return list;
	}
}
