package tree.easy;

import java.util.Deque;
import java.util.LinkedList;

public class InvertBinaryTree {
	/*
	 * Invert a binary tree.
	 * 
	 * 4/\2 7/\/\1 3 6 9 to 4/\7 2/\/\9 6 3 1
	 */

	public TreeNode solution(TreeNode root) {
		/*
		 * This solution is correct, but it is also bound to the application
		 * stack, which means that it's no so much scalable - (you can find the
		 * problem size that will overflow the stack and crash your
		 * application), so more robust solution would be to use stack data
		 * structure.
		 */
		// Your runtime beats 1.38% of java submissions. Runtime 1ms
		if (root != null) {
			TreeNode tmpNode = root.left;
			root.left = root.right;
			root.right = tmpNode;
			solution(root.left);
			solution(root.right);
		}
		return root;
	}

	public TreeNode solution2(TreeNode root) {
		// Your runtime beats 1.38% of java submissions. Runtime 1ms
		if (root == null) {
			return null;
		}

		final Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			final TreeNode node = stack.pop();
			final TreeNode left = node.left;
			node.left = node.right;
			node.right = left;

			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}
		}
		return root;
	}
}
