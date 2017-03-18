package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindModeInBinarySearchTree {
	/*
	 * Given a binary search tree (BST) with duplicates, find all the mode(s)
	 * (the most frequently occurred element) in the given BST.
	 * 
	 * Assume a BST is defined as follows:
	 * 
	 * The left subtree of a node contains only nodes with keys less than or
	 * equal to the node's key. The right subtree of a node contains only nodes
	 * with keys greater than or equal to the node's key. Both the left and
	 * right subtrees must also be binary search trees. For example: Given BST
	 * [1,null,2,2], 1 \ 2 / 2 return [2].
	 * 
	 * Note: If a tree has more than one mode, you can return them in any order.
	 * 
	 * Follow up: Could you do that without using any extra space? (Assume that
	 * the implicit stack space incurred due to recursion does not count).
	 */

	public int[] solution(TreeNode root) {
		// Your runtime beats 13.05% of java submissions. Runtime 27ms
		Map<Integer, Integer> map = new HashMap<>();
		recursion(map, root);

		int maxfreq = 0; // ??If this was set to 0 then the ret array only has
							// one element
		List<Integer> ret = new LinkedList<>();
		for (int key : map.keySet()) {
			if (maxfreq == map.get(key))
				ret.add(key);
			if (maxfreq < map.get(key)) {
				maxfreq = map.get(key);
				ret.clear();
				ret.add(key);
			}
		}
		int[] retMode = new int[ret.size()];
		int i = 0;
		for (int mode : ret) {
			retMode[i++] = mode;
		}
		return retMode;
	}

	private void recursion(Map<Integer, Integer> map, TreeNode root) {
		if (root == null)
			return;
		if (root.left != null)
			recursion(map, root.left);
		if (root.right != null)
			recursion(map, root.right);
		if (!map.containsKey(root.val))
			map.put(root.val, 1);
		else
			map.put(root.val, map.get(root.val) + 1);
	}

	public int[] solution2(TreeNode root) {
		// Your runtime beats 84.72% of java submissions. Runtime 4ms
		inorder(root);
		modes = new int[modeCount];
		modeCount = 0;
		currCount = 0;
		inorder(root);
		return modes;
	}

	private int currVal;
	private int currCount = 0;
	private int maxCount = 0;
	private int modeCount = 0;

	private int[] modes;

	private void handleValue(int val) {
		if (val != currVal) {
			currVal = val;
			currCount = 0;
		}
		currCount++;
		if (currCount > maxCount) {
			maxCount = currCount;
			modeCount = 1;
		} else if (currCount == maxCount) {
			if (modes != null)
				modes[modeCount] = currVal;
			modeCount++;
		}
	}

	private void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		handleValue(root.val);
		inorder(root.right);
	}
	
	
	
}
