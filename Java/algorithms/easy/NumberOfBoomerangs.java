package easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NumberOfBoomerangs {

	/*
	 * Given n points in the plane that are all pairwise distinct, a "boomerang"
	 * is a tuple of points (i, j, k) such that the distance between i and j
	 * equals the distance between i and k (the order of the tuple matters).
	 * 
	 * Find the number of boomerangs. You may assume that n will be at most 500
	 * and coordinates of points are all in the range [-10000, 10000]
	 * (inclusive).
	 * 
	 * Example: Input: [[0,0],[1,0],[2,0]]
	 * 
	 * Output: 2
	 * 
	 * Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and
	 * [[1,0],[2,0],[0,0]]
	 */
	public int solution(int[][] points) {
		// Your runtime beats 23.05% of java submissions. Runtime 278ms
		int ret = 0;
		for (int i = 0; i < points.length; i++) {
			Map<Integer, Integer> distMap = new HashMap<Integer, Integer>();
			for (int j = 0; j < points.length; j++)
				if (i != j) {
					int dist = getDistSqure(points[i], points[j]);
					if (!distMap.containsKey(dist))
						distMap.put(dist, 1);
					else
						distMap.put(dist, distMap.get(dist) + 1);
				}
			for (Integer value : distMap.values()) {
				ret += value * (value - 1);
			}
		}

		return ret;

	}

	public int solution2(int[][] points) {
		// !!
		// result += 2*prevDist; Use it and save a loop
		// Your runtime beats 98.14% of java submissions. Runtime 128ms

		int result = 0;
		HashMap<Integer, Integer> distMap = new HashMap<Integer, Integer>();
		for (int[] i : points) {
			for (int[] j : points) {
				if (i == j)
					continue;
				int dist = (i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1]);
				int prevDist = distMap.containsKey(dist) ? distMap.get(dist) : 0;
				result += 2 * prevDist; //Use it and save a loop
				distMap.put(dist, prevDist + 1);
			}
			distMap.clear();
		}
		return result;
	}

	public int getDistSqure(int[] p, int[] q) {
		int a = p[0] - q[0];
		int b = p[1] - q[1];
		return a * a + b * b;
	}
}
