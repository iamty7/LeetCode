package medium;

import java.util.Arrays;
import java.util.List;

public class Triangle {
	/*
	 * Given a triangle, find the minimum path sum from top to bottom. Each step
	 * you may move to adjacent numbers on the row below.
	 * 
	 * For example, given the following triangle [ [2], [3,4], [6,5,7],
	 * [4,1,8,3] ] The minimum path sum from top to bottom is 11 (i.e., 2 + 3 +
	 * 5 + 1 = 11).
	 * 
	 * Note: Bonus point if you are able to do this using only O(n) extra space,
	 * where n is the total number of rows in the triangle.
	 */

	public int solution(List<List<Integer>> triangle) {
		// Very inefficient! Time complexity O(n!)
		return dynamicProg(triangle, 0, 0);
	}

	private int dynamicProg(List<List<Integer>> triangle, int layer, int index) {
		if (layer == triangle.size())
			return 0;

		List<Integer> subList = triangle.get(layer);

		return Math.min(dynamicProg(triangle, layer + 1, index), dynamicProg(triangle, layer + 1, index + 1))
				+ subList.get(index);
	}

	public int solution2(List<List<Integer>> triangle) {
		// !! Dynamic Programming. From top to bottom
		// Your runtime beats 72.50% of java submissions. Runtime 8ms
		if (triangle == null || triangle.size() == 0)
			return 0;

		int[] minSub = new int[triangle.size()];
		Arrays.fill(minSub, Integer.MAX_VALUE);
		minSub[0] = triangle.get(0).get(0);
		for (int i = 1; i < triangle.size(); i++)
			for (int j = i; j >= 0; j--) {
				if (j == 0)
					minSub[j] = minSub[0] + triangle.get(i).get(j);
				else
					minSub[j] = Math.min(minSub[j - 1], minSub[j]) + triangle.get(i).get(j);
			}

		int minTotal = Integer.MAX_VALUE;

		for (int i = 0; i < minSub.length; i++)
			minTotal = Math.min(minTotal, minSub[i]);
		return minTotal;
	}

	public int solution3(List<List<Integer>> triangle) {
		// !! Dynamic Programming. From bottom to top
		// Your runtime beats 35.86% of java submissions. Runtime 12ms
		if (triangle == null || triangle.size() == 0)
			return 0;

		int[] minSub = new int[triangle.size()];
		for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++)
			minSub[i] = triangle.get(triangle.size() - 1).get(i);
		for (int i = triangle.size() - 2; i > -1; i--)
			for (int j = 0; j < triangle.get(i).size(); j--) {
				minSub[j] = Math.min(minSub[j], minSub[j + 1]) + triangle.get(i).get(j);
			}
		return minSub[0];
	}
}
