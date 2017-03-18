package easy;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
	/*
	 * Given a binary tree, return all root-to-leaf paths.
	 * 
	 * For example, given the following binary tree:
	 * 
	 * 1 / \ 2 3 \ 5 All root-to-leaf paths are:
	 * 
	 * ["1->2->5", "1->3"]
	 */

	public List<String> solution(TreeNode root) {
		// Your runtime beats 18.81% of java submissions. Runtime 22ms
		List<String> wrapStr = new LinkedList<String>();
		StringBuffer subStr = new StringBuffer();
		if (root == null)
			return wrapStr;

		DepthFirstSearch(wrapStr, subStr, root);

		return wrapStr;

	}

	private void DepthFirstSearch(List<String> wrapStr, StringBuffer subStr, TreeNode root) {

		int len = subStr.length();
		if (root.left == null && root.right == null) {

			subStr.append(root.val);
			wrapStr.add(subStr.toString());
			subStr.delete(len, subStr.length());
			return;
		}
		subStr.append(root.val).append("->");
		if (root.left != null) {
			DepthFirstSearch(wrapStr, subStr, root.left);
		}
		if (root.right != null) {
			DepthFirstSearch(wrapStr, subStr, root.right);
		}
		subStr.delete(len, subStr.length());
	}

	// Solution2
	public List<String> binaryTreePaths(TreeNode root) {
		// Your runtime beats 24.62% of java submissions. Runtime 21ms
		List<String> paths = new LinkedList<>();

		if (root == null)
			return paths;

		if (root.left == null && root.right == null) {
			paths.add(root.val + "");
			return paths;
		}

		for (String path : binaryTreePaths(root.left)) {
			paths.add(root.val + "->" + path);
		}

		for (String path : binaryTreePaths(root.right)) {
			paths.add(root.val + "->" + path);
		}

		return paths;

	}
}
