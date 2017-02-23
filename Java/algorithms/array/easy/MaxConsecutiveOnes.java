package array.easy;

public class MaxConsecutiveOnes {

	public int solution(int[] nums) {
		// Your runtime beats 34.23% of java submissions. Runtime 12ms
		if (nums.length == 0)
			return 0;

		int max = 0, cnt = 0;

		for (int n : nums) {
			if (n == 1)
				++cnt;
			else {
				if (cnt > max)
					max = cnt;
				cnt = 0;
			}

		}
		if (cnt > max)
			max = cnt;
		return max;

	}
}
