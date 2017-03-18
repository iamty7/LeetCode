package medium;

public class FindTheDuplicateNumber {

	/*
	 * Given an array nums containing n + 1 integers where each integer is
	 * between 1 and n (inclusive), prove that at least one duplicate number
	 * must exist. Assume that there is only one duplicate number, find the
	 * duplicate one.
	 * 
	 * Note: You must not modify the array (assume the array is read only). You
	 * must use only constant, O(1) extra space. Your runtime complexity should
	 * be less than O(n^2).
	 * 
	 * There is only one duplicate number in the array, but it could be repeated
	 * more than once.
	 */

	public int solution(int[] nums) {
		// !!! the duplicate number must be the entry point of the circle when
		// visiting the array from nums[0]
		int slow = nums[0], fast = nums[slow];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		fast = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
}
