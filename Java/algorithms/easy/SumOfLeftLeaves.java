package easy;

public class SumOfLeftLeaves {
	/*
	 * Find the sum of all left leaves in a given binary tree.
	 * 
	 * Example:
	 * 
	 *   3 
	 *  / \ 
	 * 9  20 
	 *    / \ 
	 *   15  7
	 * 
	 * There are two left leaves in the binary tree, with values 9 and 15
	 * respectively. Return 24.
	 */

	public int solution(TreeNode root) {
		// Your runtime beats 83.38% of java submissions. Runtime 8ms
		if (root == null)
			return 0;

		int leftRet = 0;
		if (root.left != null)
			if (root.left.left == null && root.left.right == null)
				leftRet = root.left.val;
			else
				leftRet += solution(root.left);

		leftRet += solution(root.right);

		return leftRet;
	}

	// Iterative method
}
