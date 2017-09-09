package hard;

public class FindMinimumInRotatedSortedArrayII {

	/*
	 * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates
	 * are allowed?
	 * 
	 * Would this affect the run-time complexity? How and why? Suppose an array
	 * sorted in ascending order is rotated at some pivot unknown to you
	 * beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * Find the minimum element.
	 * 
	 * The array may contain duplicates.
	 */

	public int findMin(int[] nums) {
		// Your runtime beats 6.61 % of java submissions. Runtime 1ms
		if (nums[0] < nums[nums.length - 1])
			return nums[0];
		int left = 0, right = nums.length - 1;
		while (left != right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[right]) {
				left = mid + 1;
				continue;
			} else if (nums[mid] < nums[right])
				right = mid;
			else
				right--;

		}
		return nums[left];
	}
}
