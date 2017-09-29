package medium;

public class ValidateBinarySearchTree {
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/*
	 * Given a binary tree, determine if it is a valid binary search tree (BST).
	 * 
	 * Assume a BST is defined as follows:
	 * 
	 * The left subtree of a node contains only nodes with keys 
	 * less than the node's key. 
	 * The right subtree of a node contains only nodes with keys
	 * greater than the node's key. 
	 * Both the left and right subtrees must also be binary search trees.
	 */

	private TreeNode preNode = null;

	public boolean isValidBST(TreeNode root) {
		// Your runtime beats 36.23 % of java submissions. Runtime 1ms
		return helper(root);
	}

	public boolean helper(TreeNode root) {
		if (root == null)
			return true;
		if (helper(root.left) == false)
			return false;
		if (preNode != null && root.val <= preNode.val)
			return false;
		else {
			preNode = root;
			return helper(root.right);
		}
	}
}
