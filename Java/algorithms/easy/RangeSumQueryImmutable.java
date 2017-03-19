package easy;

import java.util.ArrayList;
import java.util.List;

public class RangeSumQueryImmutable {
	/*
	 * Given an integer array nums, find the sum of the elements between indices
	 * i and j (i ≤ j), inclusive.
	 * 
	 * Example: Given nums = [-2, 0, 3, -5, 2, -1]
	 * 
	 * sumRange(0, 2) -> 1 sumRange(2, 5) -> -1 sumRange(0, 5) -> -3 Note: You
	 * may assume that the array does not change. There are many calls to
	 * sumRange function.
	 */

	/**
	 * Your NumArray object will be instantiated and called as such: NumArray
	 * obj = new NumArray(nums); int param_1 = obj.sumRange(i,j);
	 */

	// Time Limit Exceeded
	// private List<List<Integer>> sums ;
	//
	// public RangeSumQueryImmutable(int[] nums) {
	//
	// sums=new ArrayList<>();
	// for (int i = 0; i < nums.length; i++) {
	// List<Integer> subList = new ArrayList<>();
	// int subSum = 0;
	// for (int j = i; j < nums.length; j++) {
	// subSum += nums[j];
	// subList.add(subSum);
	// }
	// sums.add(subList);
	// }
	// }
	//
	// public int sumRange(int i, int j) {
	// return sums.get(i).get(j - i);
	// }

	// !!Your runtime beats 64.65% of java submissions. Runtime 229ms
	private int[] sums;

	public RangeSumQueryImmutable(int[] nums) {
		sums = new int[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			sums[i] = sum;
		}
	}

	public int sumRange(int i, int j) {
		return sums[j] - (i > 0 ? sums[i - 1] : 0);
	}

}
