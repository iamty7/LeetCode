package medium;

import java.util.LinkedList;
import java.util.List;

public class MajorityElementII {
	/*
	 * Given an integer array of size n, find all elements that appear more than
	 * ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
	 */

	public List<Integer> majorityElement(int[] nums) {
		// Your runtime beats 20.26% of java submissions. Runtime 7ms
		List<Integer> list = new LinkedList<>();
		if (nums.length <= 2) {
			for (int i = 0; i < nums.length; i++)
				if (!list.contains(nums[i]))
					list.add(nums[i]);
			return list;
		}
		int num0 = nums[0], num1 = nums[1], cnt0 = 0, cnt1 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == num0)
				cnt0++;
			else if (nums[i] == num1)
				cnt1++;
			else if (cnt0 == 0) {
				num0 = nums[i];
				cnt0++;
			} else if (cnt1 == 0) {
				num1 = nums[i];
				cnt1++;
			} else {
				cnt0--;
				cnt1--;
			}
		}
		cnt0 = 0;
		cnt1 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == num0)
				cnt0++;
			else if (nums[i] == num1)
				cnt1++;
		}
		if (cnt0 > nums.length / 3)
			list.add(num0);
		if (cnt1 > nums.length / 3)
			list.add(num1);
		return list;
	}
}
