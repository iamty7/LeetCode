package medium;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
	/*
	 * Given a sorted integer array without duplicates, return the summary of
	 * its ranges.
	 * 
	 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
	 */

	public List<String> summaryRanges(int[] nums) {
		// Your runtime beats 6.47% of java submissions. Runtime 1ms
		List<String> list = new LinkedList<>();
		if (nums.length == 0)
			return list;
		int start = nums[0], end;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] != 1) {
				end = nums[i - 1];
				if (end == start)
					list.add(start + "");
				else
					list.add(start + "->" + end);
				start = nums[i];
			}
		}
		if (start == nums[nums.length - 1])
			list.add(start + "");
		else
			list.add(start + "->" + nums[nums.length - 1]);
		return list;
	}
}
