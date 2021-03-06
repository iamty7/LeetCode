package easy;

public class IntersectionOfTwoLinkedLists {
	/*
	 * Write a program to find the node at which the intersection of two singly
	 * linked lists begins.
	 * 
	 * For example, the following two linked lists:
	 * 
	 * A:      a1 → a2 ↘ 
	 *                 c1 → c2 → c3 
	 * B: b1 → b2 → b3  ↗  
	 * 
	 * begin to intersect at node c1.
	 * 
	 * Notes:
	 * 
	 * If the two linked lists have no intersection at all, return null. 
	 * The linked lists must retain their original structure after the function returns. 
	 * You may assume there are no cycles anywhere in the entire linked structure. 
	 * Your code should preferably run in O(n) time and use only O(1) memory.
	 */
	
	public ListNode solution(ListNode headA, ListNode headB) {
		// !!
		// Your runtime beats 41.24% of java submissions. Runtime 2ms
		
		if(headA==null|| headB==null)
			return null;
		
		int lenA = getLen(headA);
		int lenB = getLen(headB);
		
		if (lenA > lenB)
			for (int i = 0; i < lenA - lenB; i++)
				headA = headA.next;
		else if (lenB > lenA) {
			for (int i = 0; i < lenB - lenA; i++)
				headB = headB.next;
		}

		while (headA != null) {
			if (headA == headB)
				return headA;
			headA =headA.next;
			headB=headB.next;
		}
		return null;

	}
	

	int getLen(ListNode head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}
}
