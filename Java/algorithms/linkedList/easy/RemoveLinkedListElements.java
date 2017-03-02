package linkedList.easy;

public class RemoveLinkedListElements {
	/*
	 * Remove all elements from a linked list of integers that have value val.
	 * 
	 * Example Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 Return: 1
	 * --> 2 --> 3 --> 4 --> 5
	 */

	public ListNode solution(ListNode head, int val) {
		// Your runtime beats 10.44% of java submissions. Runtime 2ms
		while (head != null) {
			if (head.val == val)
				head = head.next;
			else
				break;
		} // Or use a fake head here points to head

		if (head == null)
			return head;

		ListNode pos = head;

		while (pos.next != null) {
			if (pos.next.val == val)
				pos.next = pos.next.next;
			else
				pos = pos.next;
		}

		return head;
	}

	public ListNode solution2(ListNode head, int val) {
		// !!Slightly modified from solution1

		if (head == null)
			return head;

		ListNode pos = head;

		while (pos.next != null) {
			if (pos.next.val == val)
				pos.next = pos.next.next;
			else
				pos = pos.next;
		}

		return head.val == val ? head.next : head;// check head at last
	}

	public ListNode solution3(ListNode head, int val) {
		// !!recursion
		// Your runtime beats 10.44% of java submissions. Runtime 2ms
		if (head == null)
			return head;
		head.next = solution3(head.next, val);
		return head.val == val ? head.next : head;

	}
}
