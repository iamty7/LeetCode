package easy;

import java.util.Stack;

public class MinStack {
	/*
	 * Design a stack that supports push, pop, top, and retrieving the minimum
	 * element in constant time.
	 * 
	 * push(x) -- Push element x onto stack. 
	 * pop() -- Removes the element on top
	 * of the stack. 
	 * top() -- Get the top element. 
	 * getMin() -- Retrieve the minimum element in the stack. 
	 * 
	 * Example: 
	 * MinStack minStack = new MinStack(); 
	 * minStack.push(-2); 
	 * minStack.push(0); 
	 * minStack.push(-3);
	 * minStack.getMin(); --> Returns -3. 
	 * minStack.pop(); 
	 * minStack.top(); -->
	 * Returns 0. 
	 * minStack.getMin(); --> Returns -2.
	 */

	/*
	 * Your MinStack object will be instantiated and called as such: MinStack
	 * obj = new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */

	// !!Only one stack
	private Stack<Integer> stack;
	private int min;

	public MinStack() {
		stack = new Stack<>();
		min = Integer.MAX_VALUE;
	}

	public void push(int x) {
		if (x <= min) {
			stack.push(min); // new min appear so store the previous one
			min = x;
		}
		stack.push(x);
	}

	public void pop() {
		if (stack.isEmpty()) {
			return;
		}
		if (stack.pop() == min)
			min = stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}
}
