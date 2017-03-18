package easy;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ConvertSortedArrayToBinarySearchTree {
	/*
	 * Given an array where elements are sorted in ascending order, convert it
	 * to a height balanced BST.
	 */

	public TreeNode solution(int[] nums) {
		// Your runtime beats 5.74% of java submissions. Runtime 2ms
		TreeNode root = recursion(nums);
		return root;
	}

	private TreeNode recursion(int[] nums) {

		if (nums.length == 0)
			return null;
		if (nums.length == 1) {
			TreeNode node = new TreeNode(nums[0]);
			node.left = null;
			node.right = null;
			return node;
		}
		TreeNode node = new TreeNode(nums[nums.length / 2]);
		node.left = recursion(Arrays.copyOfRange(nums, 0, nums.length / 2));
		node.right = recursion(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
		return node;
	}

	public TreeNode solution2(int[] nums) {
		// Your runtime beats 15.00% of java submissions. Runtime 1ms
		TreeNode root = recursion2(nums, 0, nums.length);
		return root;
	}

	private TreeNode recursion2(int[] nums, int start, int end) {

		if (end - start <= 0)
			return null;
		if (end - start == 1) {
			TreeNode node = new TreeNode(nums[start]);
			node.left = null;
			node.right = null;
			return node;
		}
		TreeNode node = new TreeNode(nums[(end + start) / 2]);
		node.left = recursion2(nums, start, (end + start) / 2);
		node.right = recursion2(nums, (end + start) / 2 + 1, end);
		return node;
	}

	public TreeNode solution3(int[] nums) {
		// Your runtime beats 1.57% of java submissions. Runtime 11ms
		int len = nums.length;
		if (len == 0) {
			return null;
		}

		// 0 as a placeholder
		TreeNode head = new TreeNode(0);

		Deque<TreeNode> nodeStack = new LinkedList<TreeNode>() {
			{
				push(head);
			}
		};
		Deque<Integer> leftIndexStack = new LinkedList<Integer>() {
			{
				push(0);
			}
		};
		Deque<Integer> rightIndexStack = new LinkedList<Integer>() {
			{
				push(len - 1);
			}
		};

		while (!nodeStack.isEmpty()) {
			TreeNode currNode = nodeStack.pop();
			int left = leftIndexStack.pop();
			int right = rightIndexStack.pop();
			int mid = left + (right - left) / 2; // avoid overflow
			currNode.val = nums[mid];
			if (left <= mid - 1) {
				currNode.left = new TreeNode(0);
				nodeStack.push(currNode.left);
				leftIndexStack.push(left);
				rightIndexStack.push(mid - 1);
			}
			if (mid + 1 <= right) {
				currNode.right = new TreeNode(0);
				nodeStack.push(currNode.right);
				leftIndexStack.push(mid + 1);
				rightIndexStack.push(right);
			}
		}
		return head;
	}
}
