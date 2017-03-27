package medium;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
	/*
	 * Given a matrix of m x n elements (m rows, n columns), return all elements
	 * of the matrix in spiral order.
	 * 
	 * For example, Given the following matrix:
	 * 
	 * [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] You should return
	 * [1,2,3,6,9,8,7,4,5].
	 */

	public List<Integer> spiralOrder(int[][] matrix) {
		// Your runtime beats 27.79% of java submissions. Runtime 3ms
		List<Integer> list = new LinkedList<>();
		if (matrix.length == 0 || matrix[0].length == 0)
			return list;
		int state = 0;
		int rt = 0, rb = matrix.length - 1, cl = 0, cr = matrix[0].length - 1;
		int i = 0, j = 0;
		while (rt <= rb && cl <= cr) {
			list.add(matrix[i][j]);
			if (j == cr && state == 0) {
				rt++;
				state = (state + 1) % 4;
			}
			if (i == rb && state == 1) {
				cr--;
				state = (state + 1) % 4;
			}
			if (j == cl && state == 2) {
				rb--;
				state = (state + 1) % 4;
			}
			if (i == rt && state == 3) {
				cl++;
				state = (state + 1) % 4;
			}
			switch (state) {
			case 0:
				j++;
				break;
			case 1:
				i++;
				break;
			case 2:
				j--;
				break;
			case 3:
				i--;
				break;
			}
		}

		return list;
	}

	public List<Integer> spiralOrder2(int[][] matrix) {
		// A more consice way improved from above
		List<Integer> res = new LinkedList<Integer>();

		if (matrix.length == 0) {
			return res;
		}

		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;

		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			// Traverse Right
			for (int j = colBegin; j <= colEnd; j++) {
				res.add(matrix[rowBegin][j]);
			}
			rowBegin++;

			// Traverse Down
			for (int j = rowBegin; j <= rowEnd; j++) {
				res.add(matrix[j][colEnd]);
			}
			colEnd--;

			if (rowBegin <= rowEnd) {
				// Traverse Left
				for (int j = colEnd; j >= colBegin; j--) {
					res.add(matrix[rowEnd][j]);
				}
			}
			rowEnd--;

			if (colBegin <= colEnd) {
				// Traver Up
				for (int j = rowEnd; j >= rowBegin; j--) {
					res.add(matrix[j][colBegin]);
				}
			}
			colBegin++;
		}

		return res;
	}
}
