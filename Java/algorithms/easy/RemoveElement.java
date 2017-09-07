package easy;

public class RemoveElement {

	/*
	 * Given an array and a value, remove all instances of that value in place
	 * and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this in place
	 * with constant memory.
	 * 
	 * The order of elements can be changed. It doesn't matter what you leave
	 * beyond the new length.
	 * 
	 * Example: Given input array nums = [3,2,2,3], val = 3
	 * 
	 * Your function should return length = 2, with the first two elements of
	 * nums being 2.
	 */
	
	public int solution(int[] nums, int val) {
		// Your runtime beats 23.91 % of java submissions. Runtime 10ms
		// More concise code but more assigning operations
		int i = 0;
		for (int n : nums) {
			if (n != val)
				nums[i++] = n;
		}
		return i;
	}

	public int solution2(int[] nums, int val) {
		// Your runtime beats 52.51 % of java submissions. Runtime 9ms
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == val) {
				nums[i] = nums[len - 1];
				i--;
				len--;
			}
		}
		return len;
	}
}
