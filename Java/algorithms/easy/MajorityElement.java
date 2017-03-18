package easy;

import java.util.Arrays;
import java.util.TreeMap;

public class MajorityElement {
	/*
	 * Given an array of size n, find the majority element. The majority element
	 * is the element that appears more than ⌊ n/2 ⌋ times.
	 * 
	 * You may assume that the array is non-empty and the majority element
	 * always exist in the array.
	 */
	public int solution(int[] nums) {
		// Hashtable
		// Time Limit Exceeded
		if (nums.length == 1)
			return nums[0];

		TreeMap<Integer, Integer> freq_num = new TreeMap<>();
		int Times = nums.length / 2 - 1;

		for (int n : nums) {
			if (freq_num.containsKey(n))
				if (freq_num.get(n) == Times)
					return n;
				else
					freq_num.put(n, freq_num.get(n) + 1);
			else
				freq_num.put(n, 0);
		}

		return 0;
	}

	public int solution2(int[] nums) {
		// !!Sorting
		// Your runtime beats 42.94% of java submissions. Runtime 3ms
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	public int solution3(int[] nums) {
		// !!Moore voting algorithm
		// Your runtime beats 80.34% of java submissions. Runtime 2ms
		int cnt = 0, ret = 0;
		for (int n : nums) {
			if (cnt == 0) {
				ret = n;
				++cnt;
			} else if (ret != n)
				--cnt;
			else
				++cnt;
		}

		return ret;
	}

	public int solution4(int[] nums) {
		// !!Bit manipulation
		// Your runtime beats 28.81% of java submissions. Runtime 15ms
		int[] bit = new int[32];
		for (int num : nums)
			for (int i = 0; i < 32; i++)
				if ((num >> (31 - i) & 1) == 1)
					bit[i]++;
		int ret = 0;
		for (int i = 0; i < 32; i++) {
			bit[i] = bit[i] > nums.length / 2 ? 1 : 0;
			ret += bit[i] * (1 << (31 - i));
		}
		return ret;
	}
}
