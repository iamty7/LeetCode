package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class KdiffPairsInAnArray {

	/*
	 * Given an array of integers and an integer k, you need to find the number
	 * of unique k-diff pairs in the array. Here a k-diff pair is defined as an
	 * integer pair (i, j), where i and j are both numbers in the array and
	 * their absolute difference is k.
	 * 
	 * Example 1: Input: [3, 1, 4, 1, 5], k = 2 Output: 2 Explanation: There are
	 * two 2-diff pairs in the array, (1, 3) and (3, 5). Although we have two 1s
	 * in the input, we should only return the number of unique pairs. Example
	 * 2: Input:[1, 2, 3, 4, 5], k = 1 Output: 4 Explanation: There are four
	 * 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5). Example 3:
	 * Input: [1, 3, 1, 5, 4], k = 0 Output: 1 Explanation: There is one 0-diff
	 * pair in the array, (1, 1). Note: The pairs (i, j) and (j, i) count as the
	 * same pair. The length of the array won't exceed 10,000. All the integers
	 * in the given input belong to the range: [-1e7, 1e7].
	 */
	public int solution(int[] nums, int k) {
		// !!
		// Your runtime beats 92.61% of java submissions. Runtime 22ms
		int ans = 0;
		Arrays.sort(nums);
		for (int i = 0, j = 0; i < nums.length; i++) {
			for (j = Math.max(j, i + 1); j < nums.length && (long) nums[j] - nums[i] < k; j++)
				;
			if (j < nums.length && (long) nums[j] - nums[i] == k)
				ans++;
			while (i + 1 < nums.length && nums[i] == nums[i + 1])
				i++;
		}
		return ans;
	}

	public int solution2(int[] nums, int k) {
		// !!
		// Your runtime beats 53.36% of java submissions. Runtime 36ms
		if (k < 0 || nums == null || nums.length == 0)
			return 0;
		int cnt = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		if (k == 0)
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() >= 2)
					cnt++;
			}
		else {
			for (Map.Entry<Integer, Integer> entry : map.entrySet())
				if (map.containsKey(entry.getKey() + k))
					cnt++;
		}
		return cnt;
	}

	public int solution3(int[] nums, int k) {
		// !!!
		// Your runtime beats 37.97% of java submissions. Runtime 42ms
		if (k < 0 || nums == null || nums.length == 0)
			return 0;
		Set<Integer> already_seen = new HashSet<>();
		Set<Integer> smaller_num = new HashSet<>();

		for (int i : nums) {
			if (already_seen.contains(i - k))
				smaller_num.add(i - k);
			if (already_seen.contains(i + k))
				smaller_num.add(i);
			already_seen.add(i);
		}

		return smaller_num.size();
	}

}
