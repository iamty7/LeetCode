package linkedList.easy;

public class LinkedListCycle {

	/*
	 * Given a linked list, determine if it has a cycle in it.
	 * 
	 * Follow up: Can you solve it without using extra space?
	 */

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static boolean solution(ListNode head) {
		// Your runtime beats 7.57% of java submissions. Runtime 1ms
		if (head == null)
			return false;
		ListNode node1 = head;
		ListNode node2 = head;
		// It seems it would throw NoPointerException if node is set to null in
		// LeetCode OJ though Eclipse works fine
		while (node2.next != null && node2.next.next != null) {
			node1 = node1.next;
			node2 = node2.next.next;
			if (node1.val == node2.val) 
				// If I write node1==node2 here it would be Runtime Limit Exceeded
				return true;
		}
		return false;
		
		// LeetCode Standard Solution
//		 if (head == null || head.next == null) {
//		        return false;
//		    }
//		    ListNode slow = head;
//		    ListNode fast = head.next;
//		    while (slow != fast) {
//		        if (fast == null || fast.next == null) {
//		            return false;
//		        }
//		        slow = slow.next;
//		        fast = fast.next.next;
//		    }
//		    return true;
	}

	public static void main(String[] args) {
		LinkedListCycle.ListNode node1 = new LinkedListCycle().new ListNode(1);
		LinkedListCycle.ListNode node2 = new LinkedListCycle().new ListNode(2);
		LinkedListCycle.ListNode node3 = new LinkedListCycle().new ListNode(3);
		LinkedListCycle.ListNode node4 = new LinkedListCycle().new ListNode(4);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;

		System.out.println(LinkedListCycle.solution(node1));
	}

}
