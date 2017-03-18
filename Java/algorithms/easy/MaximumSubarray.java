package easy;

public class MaximumSubarray {
	public int solution(int[] nums) {
		// Your runtime beats 25.13% of java submissions. Runtime 18ms
		if (nums.length == 1)
			return nums[0];

		int maxEndI = nums[0];
		int max = nums[0];

		for (int i = 1; i < nums.length; i++) {
			maxEndI = Math.max(maxEndI + nums[i], nums[i]);
			max = Math.max(max, maxEndI);
		}
		return max;
	}
}
