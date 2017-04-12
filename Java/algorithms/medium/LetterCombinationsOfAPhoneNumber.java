package medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	/*
	 * Given a digit string, return all possible letter combinations that the
	 * number could represent.
	 * 
	 * A mapping of digit to letters (just like on the telephone buttons) is
	 * given below.
	 * 
	 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf",
	 * "cd", "ce", "cf"]. Note: Although the above answer is in lexicographical
	 * order, your answer could be in any order you want.
	 */
	public List<String> letterCombinations(String digits) {
		// Your runtime beats 51.56% of java submissions. Runtime 4ms
		List<String> list = new ArrayList<>();
		if (digits.length() == 0)
			return list;
		for (int i = 0; i < digits.length(); i++) {
			if (digits.charAt(i) == '1' || digits.charAt(i) == '0')
				return list;
		}

		char[][] chart = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
				{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
		helper(list, new StringBuilder(), 0, digits, chart);
		return list;
	}

	private void helper(List<String> list, StringBuilder sb, int pos, String digits, char[][] chart) {
		if (pos == digits.length())
			list.add(sb.toString());
		else {
			for (int i = 0; i < chart[digits.charAt(pos) - '2'].length; i++) {
				sb.append(chart[digits.charAt(pos) - '2'][i]);
				helper(list, sb, pos + 1, digits, chart);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
}
