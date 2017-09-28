package medium;

public class FlattenBinaryTreeToLinkedList {
	/*
	 * Flatten a binary tree to a fake "linked list" in pre-order traversal.
	 * 
	 * Don't forget to mark the left child of each node to null. Or you will get
	 * Time Limit Exceeded or Memory Limit Exceeded.
	 */

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Solution {
		/*
		 * @param root: a TreeNode, the root of the binary tree
		 * 
		 * @return:
		 */
		public void flatten(TreeNode root) {

			if (root != null)
				preOrderTraverse(root);
		}

		/*
		 * @param root: a TreeNode
		 * 
		 * @return: the last child of the subtree(preOrderTraverse)
		 */

		public TreeNode preOrderTraverse(TreeNode root) {

			if (root.left == null && root.right == null)
				return root;
			TreeNode leftLastChild = null;
			TreeNode rightChild = root.right;
			if (root.left != null) {
				leftLastChild = preOrderTraverse(root.left);
				leftLastChild.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			if (rightChild != null) {
				return preOrderTraverse(rightChild);
			} else
				return leftLastChild;

		}
	}
}
