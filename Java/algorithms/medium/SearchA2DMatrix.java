package medium;

public class SearchA2DMatrix {

	/*
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted from left to right. The first integer of
	 * each row is greater than the last integer of the previous row. For
	 * example,
	 * 
	 * Consider the following matrix:
	 * [ [1, 3, 5, 7], 
	 *   [10, 11, 16, 20], 
	 *   [23, 30, 34, 50] 
	 * ] 
	 * 
	 * Given target = 3,
	 * return true.
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		/*
		 * Use binary search.
		 * n * m matrix convert to an array => matrix[x][y] => a[x * m + y]
		 * an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];
		 */
		// Your runtime beats 78.43% of java submissions. Runtime 0ms
		if (matrix.length == 0 || matrix[0].length == 0)
			return false;
		if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1])
			return false;

		// Search for row number
		int top = 0, bot = matrix.length - 1;
		int midRow = -1;
		while (top <= bot) {
			midRow = (top + bot) / 2;
			if (matrix[midRow][0] == target)
				return true;
			if (matrix[midRow][0] > target)
				bot = midRow - 1;
			if (matrix[midRow][0] < target)
				if (matrix[midRow][matrix[0].length - 1] < target)
					top = midRow + 1;
				else
					break;
		}
		// Search for column number
		int left = 0, right = matrix[0].length - 1;
		int midCol;
		while (left <= right) {
			midCol = (left + right) / 2;
			if (matrix[midRow][midCol] == target)
				return true;
			if (matrix[midRow][midCol] > target)
				right = midCol - 1;
			if (matrix[midRow][midCol] <= target)
				left = midCol + 1;
		}
		return false;
	}
}
