package easy;

public class MinimumMovesToEqualArrayElements {
	/*
	 * Given a non-empty integer array of size n, find the minimum number of
	 * moves required to make all array elements equal, where a move is
	 * incrementing n - 1 elements by 1.
	 * 
	 * Example:
	 * 
	 * Input: [1,2,3]
	 * 
	 * Output: 3
	 * 
	 * Explanation: Only three moves are needed (remember each move increments
	 * two elements):
	 * 
	 * [1,2,3] => [2,3,3] => [3,4,3] => [4,4,4]
	 */

	public int minMoves(int[] nums) {
		// Your runtime beats 78.78% of java submissions. Runtime 12ms
		int min = Integer.MAX_VALUE;
		for (int n : nums) {
			min = Math.min(min, n);
		}

		int step = 0;
		for (int n : nums) {
			step += n - min;
		}
		return step;
	}
}
