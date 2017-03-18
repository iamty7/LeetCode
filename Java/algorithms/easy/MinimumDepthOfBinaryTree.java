package easy;

public class MinimumDepthOfBinaryTree {
	/*
	 * Given a binary tree, find its minimum depth.
	 * 
	 * The minimum depth is the number of nodes along the shortest path from the
	 * root node down to the nearest leaf node.
	 */

	public int solution(TreeNode root) {
		// Your runtime beats 21.24% of java submissions. Runtime 1ms
		if (root == null)
			return 0;

		int leftDepth = solution(root.left);
		int rightDepth = solution(root.right);
		return (leftDepth == 0 || rightDepth == 0) ? leftDepth + rightDepth + 1 : Math.min(leftDepth, rightDepth) + 1;
	}
}
