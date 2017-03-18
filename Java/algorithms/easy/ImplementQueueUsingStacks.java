package easy;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	/*
	 * Implement the following operations of a queue using stacks.
	 * 
	 * push(x) -- Push element x to the back of queue. 
	 * pop() -- Removes the
	 * element from in front of queue. 
	 * peek() -- Get the front element. 
	 * empty() -- Return whether the queue is empty. 
	 * 
	 * Notes: 
	 * You must use only standard operations of a stack -- which means only 
	 * push to top, peek/pop from top, size, and is empty operations are valid. 
	 * Depending on your language,
	 * stack may not be supported natively. 
	 * You may simulate a stack by using a list or deque (double-ended queue), 
	 * as long as you use only standard operations of a stack. You may assume 
	 * that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
	 */

	// Your runtime beats 81.14% of java submissions. Runtime 96ms
	private Stack<Integer> stack;
	private Stack<Integer> tmp;

	public ImplementQueueUsingStacks() {
		stack = new Stack<>();
		tmp = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		while (!stack.isEmpty())
			tmp.push(stack.pop());
		stack.push(x);
		while (!tmp.isEmpty())
			stack.push(tmp.pop());
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		return stack.pop();
	}

	/** Get the front element. */
	public int peek() {
		return stack.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stack.isEmpty();
	}
}
