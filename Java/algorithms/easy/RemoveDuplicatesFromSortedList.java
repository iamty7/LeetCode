package easy;

public class RemoveDuplicatesFromSortedList {
	/*
	 * Given a sorted linked list, delete all duplicates such that each element
	 * appear only once.
	 * 
	 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return
	 * 1->2->3.
	 */

	public ListNode solution(ListNode head) {
		// Your runtime beats 17.57% of java submissions. Runtime 1ms
		if (head == null)
			return head;

		ListNode pos = head;
		while (pos.next != null) {
			if (pos.val == pos.next.val)
				pos.next = pos.next.next;
			else
				pos = pos.next;
		}

		return head;
	}
}
