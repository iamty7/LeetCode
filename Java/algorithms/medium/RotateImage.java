package medium;

public class RotateImage {
	/*
	 * You are given an n x n 2D matrix representing an image.
	 * 
	 * Rotate the image by 90 degrees (clockwise).
	 * 
	 * Follow up: Could you do this in-place?
	 */

	public void rotate(int[][] matrix) {
		// Your runtime beats 74.72% of java submissions. Runtime 2ms
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++)
			for (int j = i; j < n - i - 1; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];

				matrix[n - 1 - j][1 + i] = matrix[n - 1 - i][n - 1 - j];

				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];

				matrix[j][n - 1 - i] = tmp;
			}
	}
}
