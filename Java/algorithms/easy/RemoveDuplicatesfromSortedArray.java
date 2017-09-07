package easy;

public class RemoveDuplicatesfromSortedArray {

	/*
	 * Given a sorted array, remove the duplicates in place such that each
	 * element appear only once and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this in place
	 * with constant memory.
	 * 
	 * For example, Given input array nums = [1,1,2],
	 * 
	 * Your function should return length = 2, with the first two elements of
	 * nums being 1 and 2 respectively. It doesn't matter what you leave beyond
	 * the new length.
	 */

	public int solution(int[] nums) {

		// �Ƿ��������������ͬ�����ֱ�i++�����������
		int len = nums.length;
		int pos = 0;
		int dupNum = 0;
		int i = 0;

		if (len == 0)
			return 0;
		if (len == 1)
			return 1;

		if (nums[len - 1] == nums[len - 2] && pos != i - 1)
			dupNum++;

		while (i < nums.length - 1) {
			while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
				i++;
				dupNum++;
			}
			pos++;
			i++;
			nums[pos] = nums[i];

		}

		return len - dupNum;
	}

	public int solution2(int[] nums) {
		int i = nums.length > 0 ? 1 : 0;
		for (int n : nums)
			if (n > nums[i - 1])
				nums[i++] = n;
		return i;
	}

	public int solution3(int[] nums) {
		if (nums.length == 0)
			return 0;
		int j = 0;
		for (int i = 0; i < nums.length; i++)
			if (nums[i] != nums[j])
				nums[++j] = nums[i];
		return ++j;
	}

	public int solution4(int[] nums) {
		// Your runtime beats 89.01 % of java submissions. Runtime 12ms
		int i = 0;
		for (int n : nums) {
			if (n != nums[i])
				i++;
			nums[i] = n;
		}
		return i + 1;
	}
}
