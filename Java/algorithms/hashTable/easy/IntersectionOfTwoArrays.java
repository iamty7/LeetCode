package hashTable.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {
	/*
	 * Given two arrays, write a function to compute their intersection.
	 * 
	 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
	 * 
	 * Note: Each element in the result must be unique. The result can be in any
	 * order.
	 */

	public int[] solution(int[] nums1, int[] nums2) {
		// Your runtime beats 48.63% of java submissions. Runtime 6ms
		Set<Integer> retSet = new HashSet<>();
		HashSet<Integer> num1Set = new HashSet<>();

		for (int i : nums1) {
			num1Set.add(i);
		}

		for (int i : nums2) {
			if (num1Set.contains(i))
				retSet.add(i);
		}

		int[] ret = new int[retSet.size()];
		int i = 0;
		for (int n : retSet) {
			ret[i] = n;
			i++;
		}
		return ret;
	}

	// Solution2: Sort the two arrays and compare each element

	// Solution3: Get out of the elements from nums1 one by one and bianry
	// search it in nums2
}
