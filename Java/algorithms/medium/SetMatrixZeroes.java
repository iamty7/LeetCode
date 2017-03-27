package medium;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetMatrixZeroes {
	/*
	 * Given a m x n matrix, if an element is 0, set its entire row and column
	 * to 0. Do it in place.
	 * 
	 * Follow up: Did you use extra space? A straight forward solution using
	 * O(mn) space is probably a bad idea. A simple improvement uses O(m + n)
	 * space, but still not the best solution. Could you devise a constant space
	 * solution?
	 */

	public void setZeroes(int[][] matrix) {
		// Space Complexity O(m+n)
		// Your runtime beats 3.89% of java submissions. Runtime 7ms
		Set<Integer> iSet = new HashSet<>();
		Set<Integer> jSet = new HashSet<>();
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					iSet.add(i);
					jSet.add(j);
				}
			}
		for (int i : iSet) {
			for (int j = 0; j < matrix[0].length; j++)
				matrix[i][j] = 0;
		}
		for (int j : jSet) {
			for (int i = 0; i < matrix[0].length; i++)
				matrix[i][j] = 0;
		}
	}

	public void setZeroes2(int[][] matrix) {
		// !! Use the matrix instead of extra space
		// Your runtime beats 27.46% of java submissions. Runtime 2ms
		int col0 = 1, rows = matrix.length, cols = matrix[0].length;

		for (int i = 0; i < rows; i++) {
			if (matrix[i][0] == 0)
				col0 = 0;
			for (int j = 1; j < cols; j++)
				if (matrix[i][j] == 0)
					matrix[i][0] = matrix[0][j] = 0;
		}
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = cols - 1; j >= 1; j--)
				if (matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			if (col0 == 0)
				matrix[i][0] = 0;
		}
	}
}
