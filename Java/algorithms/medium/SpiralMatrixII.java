package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixII {
	/*
	 * Given an integer n, generate a square matrix filled with elements from 1
	 * to n^2 in spiral order.
	 * 
	 * For example, Given n = 3,
	 * 
	 * You should return the following matrix: 
	 * [ 
	 *  [ 1, 2, 3 ], 
	 *  [ 8, 9, 4 ], 
	 *  [ 7, 6, 5 ] 
	 * ]
	 */

	public int[][] generateMatrix(int n) {
		// This one is based on the Spiral Matrix I, not a solution to II
		int[][] array = new int[n][n];
		int rStart = 0, rEnd = n - 1, cStart = 0, cEnd = n - 1;

		int cnt = 0;
		while (cnt < n * n) {
			for (int k = cStart; k <= cEnd; k++) {
				array[cnt / n][cnt % n] = rStart * n + k + 1;
				cnt++;
			}
			rStart++;
			for (int k = rStart; k <= rEnd; k++) {
				array[cnt / n][cnt % n] = k * n + cEnd + 1;
				cnt++;
			}
			cEnd--;
			for (int k = cEnd; k >= cStart; k--) {
				array[cnt / n][cnt % n] = rEnd * n + k + 1;
				cnt++;
			}
			rEnd--;
			for (int k = rEnd; k >= rStart; k--) {
				array[cnt / n][cnt % n] = k * n + cStart + 1;
				cnt++;
			}
			cStart++;
		}
		return array;
	}

	public int[][] generateMatrix2(int n) {
		// Your runtime beats 19.64% of java submissions. Runtime 3ms
		int[][] array = new int[n][n];
		int rStart = 0, rEnd = n - 1, cStart = 0, cEnd = n - 1;
		int cnt = 1;
		while (cnt <= n * n) {
			for (int k = cStart; k <= cEnd; k++)
				array[rStart][k] = cnt++;
			rStart++;
			
			for (int k = rStart; k <= rEnd; k++)
				array[k][cEnd] = cnt++;
			cEnd--;
			
			for (int k = cEnd; k >= cStart; k--)
				array[rEnd][k] = cnt++;
			rEnd--;
			
			for (int k = rEnd; k >= rStart; k--)
				array[k][cStart] = cnt++;
			cStart++;
		}
		return array;
	}
}
