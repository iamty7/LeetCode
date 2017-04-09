package medium;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
	/*
	 * Given n pairs of parentheses, write a function to generate all
	 * combinations of well-formed parentheses.
	 * 
	 * For example, given n = 3, a solution set is:
	 * 
	 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
	 */

	public List<String> generateParenthesis(int n) {
		// Your runtime beats 32.49% of java submissions. Runtime 4ms
		List<String> list = new LinkedList();
		generateOneByOne("", list, n, n);
		return list;
	}

	public void generateOneByOne(String sublist, List<String> list, int left, int right) {
		if (left > right) {
			return;
		}
		if (left > 0) {
			generateOneByOne(sublist + "(", list, left - 1, right);
		}
		if (right > 0) {
			generateOneByOne(sublist + ")", list, left, right - 1);
		}
		if (left == 0 && right == 0) {
			list.add(sublist);
			return;
		}
	}
}
