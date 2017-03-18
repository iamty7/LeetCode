package easy;

public class ReverseLinkedList {
	/* Reverse Linked List */

	public ListNode solution(ListNode head) {
		// Your runtime beats 4.00% of java submissions. Runtime 1ms
		if (head == null)
			return head;
		ListNode pre = null;
		ListNode next = head.next;
		while (next != null) {
			head.next = pre;
			pre = head;
			head = next;
			next = next.next;
		}
		head.next = pre;
		return head;
	}

	public ListNode solution2(ListNode head) {
		// !recursion
		// Your runtime beats 35.16% of java submissions. Runtime 0ms
		return recursion(head, null);

	}

	public ListNode recursion(ListNode head, ListNode pre) {
		if (head == null)
			return pre;
		ListNode next = head.next;
		head.next = pre;
		return recursion(next, head);
	}

	public ListNode reverseList(ListNode head) {
		// !!recursion
		// Your runtime beats 4.00% of java submissions. Runtime 1ms
		if (head == null || head.next == null)
			return head;
		ListNode p = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}

}
