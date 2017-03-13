package tree.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import sun.reflect.generics.tree.Tree;

public class SameTree {
	/*
	 * Given two binary trees, write a function to check if they are equal or
	 * not.
	 * 
	 * Two binary trees are considered equal if they are structurally identical
	 * and the nodes have the same value.
	 */

	public boolean solution(TreeNode p, TreeNode q) {
		// Your runtime beats 2.59% of java submissions. Runtime 1ms
		if (p == null || q == null)
			if (p == null && q == null)
				return true;
			else
				return false;

		Queue<TreeNode> queue1 = new LinkedList();
		Queue<TreeNode> queue2 = new LinkedList();
		queue1.offer(p);
		queue2.offer(q);

		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			TreeNode node1 = queue1.poll();
			TreeNode node2 = queue2.poll();
			if (node1 == null || node2 == null)
				if (!(node1 == null && node2 == null))
					return false;
				else
					continue;
			if (node1.val != node2.val)
				return false;
			queue1.offer(node1.left);
			queue1.offer(node1.right);
			queue2.offer(node2.left);
			queue2.offer(node2.right);
		}

		if (queue1.isEmpty() == queue2.isEmpty())
			return true;
		return false;
	}

	public boolean solution2(TreeNode p, TreeNode q) {
		// Your runtime beats 24.21% of java submissions. Runtime 2ms
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val == q.val)
			return solution2(p.left, q.left) && solution2(p.right, q.right);
		return false;
	}
}
