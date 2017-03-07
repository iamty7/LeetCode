package tree.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
	/*
	 * Given a binary tree, return the bottom-up level order traversal of its
	 * nodes' values. (ie, from left to right, level by level from leaf to
	 * root). 
	 * 
	 * For example: 
	 * Given binary tree [3,9,20,null,null,15,7], 
	 *   3 
	 *  / \ 
	 * 9  20
	 *    / \ 
	 *   15  7 
	 *  
	 * return its bottom-up level order traversal as: 
	 * [ 
	 *  [15,7], 
	 *  [9,20],
	 *  [3] 
	 * ]
	 */
	
	public List<List<Integer>> solution(TreeNode root) {
		// Breadth-First-Search
		// Your runtime beats 9.27% of java submissions. Runtime 4ms
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

		if (root == null)
			return wrapList;
		queue.offer(root);

		while (!queue.isEmpty()) {
			List<Integer> subList = new LinkedList<>();
			int levelNum = queue.size();
			for (int i = 0; i < levelNum; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);
				if (queue.peek().right != null)
					queue.offer(queue.peek().right);
				subList.add(queue.poll().val);
			}
			wrapList.add(0, subList);

		}
		return wrapList;
	}

}
