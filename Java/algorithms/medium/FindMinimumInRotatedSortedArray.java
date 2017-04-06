package medium;

public class FindMinimumInRotatedSortedArray {
	/*
	 * Suppose an array sorted in ascending order is rotated at some pivot
	 * unknown to you beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * Find the minimum element.
	 * 
	 * You may assume no duplicate exists in the array.
	 */

	public int findMin(int[] nums) {
		// Your runtime beats 5.20% of java submissions. Runtime 1ms
		if (nums.length == 2)
			return Math.min(nums[0], nums[1]);
		if (nums[0] <= nums[nums.length - 1])
			return nums[0];
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
				if (nums[left] < nums[mid])
					left = mid + 1;
				else
					right = mid;
			} else
				return Math.min(Math.min(nums[mid - 1], nums[mid]), nums[mid + 1]);
		}
		return nums[0];
	}

	public int findMin2(int[] nums) {
		// !!
		// Your runtime beats 70.53% of java submissions. Runtime 1ms
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		int left = 0, right = nums.length - 1;
		// while (left < right-1) is a useful technique
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[right]) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return Math.min(nums[left], nums[right]);
	}
}
