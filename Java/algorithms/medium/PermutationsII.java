package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII {
	/*
	 * Given a collection of numbers that might contain duplicates, return all
	 * possible unique permutations.
	 * 
	 * For example, [1,1,2] have the following unique permutations: [ [1,1,2],
	 * [1,2,1], [2,1,1] ]
	 */

	public List<List<Integer>> permuteUnique(int[] nums) {
		// Your runtime beats 35.29% of java submissions. Runtime 11ms
		List<List<Integer>> list = new LinkedList<>();
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		helper(list, nums, used, 0, new LinkedList<>());
		return list;
	}

	private void helper(List<List<Integer>> list, int[] nums, boolean[] used, int cnt, LinkedList tmp) {
		if (cnt == nums.length)
			list.add(new LinkedList<>(tmp));
		else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i])
					continue;
				tmp.add(nums[i]);
				used[i] = true;
				helper(list, nums, used, cnt + 1, tmp);
				tmp.removeLast();
				used[i] = false;
				while (i + 1 < nums.length && nums[i] == nums[i + 1])
					i++;
			}
		}
	}

}
