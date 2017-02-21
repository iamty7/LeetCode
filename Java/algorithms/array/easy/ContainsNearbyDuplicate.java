package array.easy;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsNearbyDuplicate {

	public boolean solution(int[] nums, int k) {
		// Your runtime beats 34.12% of java submissions. Runtime 20ms
		HashMap<Integer, Integer> flagMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (flagMap.containsKey(nums[i]))
				if (Math.abs(i - flagMap.get(nums[i]).intValue()) <= Math.abs(k))
					return true;
				else
					flagMap.put(nums[i], i);
			flagMap.put(nums[i], i);
		}

		return false;

	}

	public boolean solution2(int[] nums, int k) {
		// Your runtime beats 80.00% of java submissions.
		if (nums.length <= 1 || k <= 0) {
			return false;
		}
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (!set.add(nums[i])) {
				return true;
			}
			if (i >= k) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}
}
