package medium;

public class RemoveDuplicatesFromSortedArrayII {
	/*
	 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
	 * twice?
	 * 
	 * For example, Given sorted array nums = [1,1,1,2,2,3],
	 * 
	 * Your function should return length = 5, with the first five elements of
	 * nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the
	 * new length.
	 */

	public int removeDuplicates(int[] nums) {
		// Your runtime beats 38.78% of java submissions. Runtime 1ms
		if (nums.length <= 2)
			return nums.length;

		int len = nums.length;
		int j = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[j]) {
				nums[++j] = nums[i];

				i++;
				while (i < nums.length && nums[i] == nums[j]) {
					i++;
					len--;
				}
			}
			if (i == nums.length)
				break;
			nums[++j] = nums[i];
		}
		// because of the while loop, the last element may have not been
		nums[j] = nums[nums.length - 1];
		return len;
	}

	public int removeDuplicates2(int[] nums) {
		int i = 0;
		for (int n : nums)
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;
		return i;
	}
}
