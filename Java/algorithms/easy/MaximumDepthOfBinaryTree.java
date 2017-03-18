package easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MaximumDepthOfBinaryTree {
	/*
	 * Given a binary tree, find its maximum depth.
	 * 
	 * The maximum depth is the number of nodes along the longest path from the
	 * root node down to the farthest leaf node.
	 */

	public int solution(TreeNode root) {
		// Your runtime beats 18.63% of java submissions. Runtime 1ms
		if (root == null)
			return 0;
		return (Math.max(solution(root.left), solution(root.right))) + 1;
	}

	public int solution2(TreeNode root) {
		// Your runtime beats 5.24% of java submissions. Runtime 3ms
		if (root == null)
			return 0;

		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		int count = 0;
		while (!stack.isEmpty()) {
			int size = stack.size();
			while (size-- > 0) {
				TreeNode cur = stack.pop();
				if (cur.left != null)
					stack.addLast(cur.left);
				if (cur.right != null)
					stack.addLast(cur.right);
			}
			count++;
		}
		return count;
	}

}
