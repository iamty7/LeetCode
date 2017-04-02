package medium;

public class SearchForARange {
	/*
	 * Given an array of integers sorted in ascending order, find the starting
	 * and ending position of a given target value.
	 * 
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * 
	 * If the target is not found in the array, return [-1, -1].
	 * 
	 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
	 */

	public int[] searchRange(int[] nums, int target) {
		// Your runtime beats 53.67% of java submissions. Runtime 8ms
		int i = binarySearch(nums, 0, nums.length - 1, target);
		if (i == -1)
			return new int[] { -1, -1 };

		int preLeft = i, preRight = i;
		int curLeft = i, curRight = i;

		while (curLeft != -1) {
			preLeft = curLeft;
			curLeft = binarySearch(nums, 0, curLeft - 1, target);
		}
		while (curRight != -1) {
			preRight = curRight;
			curRight = binarySearch(nums, curRight + 1, nums.length - 1, target);
		}
		return new int[] { preLeft, preRight };
	}

	private int binarySearch(int[] nums, int i, int j, int target) {
		int mid = -1;
		while (i <= j) {
			mid = (i + j) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				j = mid - 1;
			else
				i = mid + 1;
		}
		if (i > j)
			return -1;
		else
			return mid;
	}
}
