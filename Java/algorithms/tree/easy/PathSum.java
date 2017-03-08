package tree.easy;

public class PathSum {
	/*
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf
	 * path such that adding up all the values along the path equals the given
	 * sum.
	 * 
	 * For example: Given the below binary tree and sum = 22, 5 / \ 4 8 / / \ 11
	 * 13 4 / \ \ 7 2 1 return true, as there exist a root-to-leaf path
	 * 5->4->11->2 which sum is 22.
	 */

	public boolean solution(TreeNode root, int sum) {
		// Your runtime beats 15.51% of java submissions. Runtime 1ms
		if (root == null)
			return false;

		return DepthFirstSearch(root, sum, 0);
	}

	private boolean DepthFirstSearch(TreeNode root, int sum, int sumByNow) {
		if (root.left == null && root.right == null) {
			if (sumByNow + root.val == sum) {
				return true;
			}
		}
		if (root.left != null) {
			if (DepthFirstSearch(root.left, sum, sumByNow + root.val))
				return true;
		}
		if (root.right != null) {
			if (DepthFirstSearch(root.right, sum, sumByNow + root.val))
				return true;
		}

		return false;
	}

	// !!Solution2
	public boolean hasPathSum(TreeNode root, int sum) {
		// Your runtime beats 15.51% of java submissions. Runtime 1ms
		if (root == null)
			return false;
		if (root.left == null && root.right == null && sum == root.val)
			return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}
