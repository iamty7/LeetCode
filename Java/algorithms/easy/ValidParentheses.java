package easy;

import java.util.Stack;

import com.sun.org.apache.regexp.internal.recompile;

public class ValidParentheses {
	/*
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid.
	 * 
	 * The brackets must close in the correct order, "()" and "()[]{}" are all
	 * valid but "(]" and "([)]" are not.
	 */

	public boolean solution(String s) {
		// Your runtime beats 13.81% of java submissions. Runtime 14ms
		Stack<Integer> brackets = new Stack<>();

		int value;
		for (int i = 0; i < s.length(); i++) {
			value = getValue(s.charAt(i));
			if (value > 0)
				brackets.push(value);
			else if (brackets.isEmpty())
				return false;
			else if (brackets.pop() + value != 0)
				return false;

		}
		if (brackets.isEmpty())
			return true;
		else
			return false;
	}

	public int getValue(char c) {
		switch (c) {
		case '(':
			return 1;
		case '{':
			return 2;
		case '[':
			return 3;
		case ')':
			return -1;
		case '}':
			return -2;
		case ']':
			return -3;
		default:
			break;
		}

		return 0;
	}

	public boolean solution2(String s) {
		// Your runtime beats 3.01% of java submissions. Runtime 21ms
		int[] flags = new int[s.length()];

		for (int i = 0; i < s.length(); i++) {
			flags[i] = getValue(s.charAt(i));
			if (flags[i] < 0) {
				int j;
				boolean flag = false;
				for (j = i - 1; j > -1; j--) {
					if (flags[j] > 0)
						if (flags[j] + flags[i] == 0) {
							flags[i] = 0;
							flags[j] = 0;
							flag = true;
							break;
						} else
							return false;
					else
						continue;
				}
				if (flag == false)
					return false;
			}
		}

		for (int i = 0; i < s.length(); i++) {
			if (flags[i] != 0)
				return false;
		}

		return true;
	}

	public boolean solution3(String s) {
		// !!
		// Your runtime beats 44.85% of java submissions. Runtime 11ms
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}
