package tree.easy;

import java.util.Stack;

public class BalancedBinaryTree {
	/*
	 * Given a binary tree, determine if it is height-balanced.
	 * 
	 * For this problem, a height- balanced binary tree is defined as a binary
	 * tree in which the depth of the two subtrees of every node never differ by
	 * more than 1.
	 */
	public boolean solution(TreeNode root) {
		// Your runtime beats 27.15% of java submissions. Runtime 2ms
		if (root == null)
			return true;

		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		return (!(Math.abs(leftDepth - rightDepth) > 1)) && solution(root.left) && solution(root.right);
	}

	private int getDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
	}

	public boolean solution2(TreeNode root) {
		// Your runtime beats 76.41% of java submissions. Runtime 76.41
		return !(dfsRecursion(root) == -1);
	}

	private int dfsRecursion(TreeNode root) {
		if (root == null)
			return 0;
		int leftDepth = dfsRecursion(root.left);
		if (leftDepth == -1)
			return -1;
		int rightDepth = dfsRecursion(root.right);
		if (rightDepth == -1)
			return -1;
		if (Math.abs(leftDepth - rightDepth) > 1)
			return -1;

		return Math.max(leftDepth, rightDepth) + 1;
	}
}
