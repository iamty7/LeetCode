package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubSetsII {

	/*
	 * Given a collection of integers that might contain duplicates, nums,
	 * return all possible subsets.
	 * 
	 * Note: The solution set must not contain duplicate subsets.
	 * 
	 * For example, If nums = [1,2,2], a solution is:
	 * 
	 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
	 */

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		// Your runtime beats 23.55% of java submissions. Runtime 4ms
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		Arrays.sort(nums);
		list.add(new LinkedList<Integer>());

		for (int i = 0; i < nums.length; i++) {
			int cnt = 1;
			while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
				i++;
				cnt++;
			}
			int listLen = list.size();
			for (int r = 0; r < cnt; r++) {
				for (int j = 0; j < listLen; j++) {
					List<Integer> subList = new LinkedList<>(list.get(j + listLen * r));
					subList.add(nums[i]);
					list.add(subList);
				}
			}
		}
		return list;
	}

	public List<List<Integer>> subsetsWithDup2(int[] nums) {
		// !! Slightly improved from last one
		// Your runtime beats 36.53% of java submissions. Runtime 3ms
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());
		int begin = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1])
				begin = 0;
			int size = result.size();
			for (int j = begin; j < size; j++) {
				List<Integer> cur = new ArrayList<Integer>(result.get(j));
				cur.add(nums[i]);
				result.add(cur);
			}
			begin = size;
		}
		return result;
	}
}
