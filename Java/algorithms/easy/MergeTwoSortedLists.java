package easy;

public class MergeTwoSortedLists {
	/*
	 * Merge two sorted linked lists and return it as a new list. The new list
	 * should be made by splicing together the nodes of the first two lists.
	 */

	public ListNode solution(ListNode l1, ListNode l2) {
		// !!
		// Your runtime beats 17.08% of java submissions. Runtime 18ms
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode head = new ListNode(0);
		ListNode tail = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				tail.next = l1;
				l1 = l1.next;
				tail = tail.next;
			} else {
				tail.next = l2;
				l2 = l2.next;
				tail = tail.next;
			}

		}
		tail.next = l1 == null ? l2 : l1;
		return head.next;

	}

	public ListNode solution2(ListNode l1, ListNode l2) {
		// !!very elegant recursion solution
		// Your runtime beats 73.08% of java submissions. Runtime 15ms
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		if (l1.val > l2.val) {
			l2.next = solution(l1, l2.next);
			return l2;
		} else {
			l1.next = solution(l1.next, l2);
			return l1;
		}

	}
}
