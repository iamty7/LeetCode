package medium;

import java.util.HashMap;
import java.util.Map;

import easy.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	/*
	 * Given preorder and inorder traversal of a tree, construct the binary
	 * tree.
	 * 
	 * Note: You may assume that duplicates do not exist in the tree.
	 */

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// Your runtime beats 86.22% of java submissions. Runtime 5ms
		if (inorder == null || inorder.length == 0)
			return null;

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return helper(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, map);
	}

	private TreeNode helper(int[] inorder, int i, int j, int[] preorder, int k, int l, Map<Integer, Integer> map) {
		if (i > j || k > l)
			return null;
		int curRootIndex = map.get(preorder[k]);
		TreeNode root = new TreeNode(preorder[k]);
		TreeNode leftNode = helper(inorder, i, curRootIndex - 1, preorder, k + 1, curRootIndex - i + k, map);
		TreeNode rightNode = helper(inorder, curRootIndex + 1, j, preorder, curRootIndex - j + l + 1, l, map);
		root.setLeft(leftNode);
		root.setRight(rightNode);
		return root;
	}
	
	// Iterative Solution
}
