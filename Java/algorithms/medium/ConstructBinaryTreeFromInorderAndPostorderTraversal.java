package medium;

import java.util.HashMap;
import java.util.Map;
import easy.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	/*
	 * Given inorder and postorder traversal of a tree, construct the binary
	 * tree.
	 * 
	 * Note: You may assume that duplicates do not exist in the tree.
	 */

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// Your runtime beats 70.58% of java submissions. Runtime 6ms
		if (inorder == null || inorder.length == 0)
			return null;

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
	}

	private TreeNode helper(int[] inorder, int i, int j, int[] postorder, int k, int l, Map<Integer, Integer> map) {
		if (i > j || k > l)
			return null;
		int curRootIndex = map.get(postorder[l]);
		TreeNode root = new TreeNode(postorder[l]);
		TreeNode leftNode = helper(inorder, i, curRootIndex - 1, postorder, k, curRootIndex - i + k - 1, map);
		TreeNode rightNode = helper(inorder, curRootIndex + 1, j, postorder, l + curRootIndex - j, l - 1, map);
		root.setLeft(leftNode);
		root.setRight(rightNode);
		return root;
	}
}
