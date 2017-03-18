package easy;

import java.util.Stack;

public class PalindromeLinkedList {
	/*
	 * Given a singly linked list, determine if it is a palindrome.
	 * 
	 * Follow up: Could you do it in O(n) time and O(1) space?
	 */

	public boolean solution(ListNode head) {
		// Your runtime beats 10.39% of java submissions. Runtime 5ms
		int len = 0;
		ListNode cur = head;
		while (cur != null) {
			len++;
			cur = cur.next;
		}

		Stack<Integer> valStack = new Stack<>();

		int i = 1;
		cur = head;
		for (; i <= len / 2; i++) {
			valStack.push(cur.val);
			cur = cur.next;
		}

		if (len % 2 == 1) {
			i++;
			cur = cur.next;
		}

		for (; i <= len; i++) {
			if (cur.val != valStack.pop())
				return false;
			cur = cur.next;
		}

		return true;
	}

	public boolean solution2(ListNode head) {
		// !!First reverse half of the list
		// Your runtime beats 21.42% of java submissions. Runtime 3ms
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast != null)
			slow = slow.next;

		slow = ReverseLinkedList(slow);
		fast = head;

		while (slow != null) {
			if (slow.val != fast.val)
				return false;
			slow = slow.next;
			fast = fast.next;
		}
		return true;

	}

	private ListNode ReverseLinkedList(ListNode head) {

		ListNode pre = null;
		ListNode next = head;
		while (next != null) {
			head = next;
			next = next.next;
			head.next = pre;
			pre = head;
		}
		return head;
	}

}
