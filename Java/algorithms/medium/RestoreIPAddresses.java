package medium;

import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
	/*
	 * Given a string containing only digits, restore it by returning all
	 * possible valid IP address combinations.
	 * 
	 * For example: Given "25525511135",
	 * 
	 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
	 */

	public List<String> restoreIpAddresses(String s) {
		// Your runtime beats 91.04% of java submissions. Runtime 3ms
		List<String> list = new LinkedList<>();
		if (s.length() < 4 || s.length() > 12)
			return list;
		helper(list, s, 0, 0, new StringBuilder());
		return list;
	}

	private void helper(List<String> list, String s, int ibyte, int iStr, StringBuilder stringBuilder) {

		if ((ibyte == 4 && iStr != s.length()) || (iStr == s.length() && ibyte != 4))
			return;
		else if (ibyte == 4 && iStr == s.length()) {
			list.add(stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString());
			stringBuilder.append(".");
		} else {
			if (s.charAt(iStr) == '0') {
				stringBuilder.append(s.charAt(iStr)).append('.');
				helper(list, s, ibyte + 1, iStr + 1, stringBuilder);
				stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
			} else if (iStr < s.length()) {
				stringBuilder.append(s.charAt(iStr)).append('.');
				helper(list, s, ibyte + 1, iStr + 1, stringBuilder);
				stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
				if (iStr + 1 < s.length()) {
					stringBuilder.append(s.charAt(iStr)).append(s.charAt(iStr + 1)).append('.');
					helper(list, s, ibyte + 1, iStr + 2, stringBuilder);
					stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());
					if (iStr + 2 < s.length()
							&& (s.charAt(iStr) < '2' || (s.charAt(iStr) == '2' && (s.charAt(iStr + 1) < '5'
									|| (s.charAt(iStr + 1) == '5' && s.charAt(iStr + 2) < '6'))))) {
						stringBuilder.append(s.charAt(iStr)).append(s.charAt(iStr + 1)).append(s.charAt(iStr + 2))
								.append('.');
						helper(list, s, ibyte + 1, iStr + 3, stringBuilder);
						stringBuilder.delete(stringBuilder.length() - 4, stringBuilder.length());
					}
				}
			}

		}
	}
	
	public List<String> restoreIpAddresses2(String s) {
		// !!
		// Your runtime beats 21.69% of java submissions. Runtime 7ms
		List<String> res = new LinkedList();
		int len = s.length();
		for (int i = 1; i < 4 && i < len - 2; i++) {
			for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
				for (int k = j + 1; k < j + 4 && k < len; k++) {
					String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k),
							s4 = s.substring(k, len);
					if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
						res.add(s1 + "." + s2 + "." + s3 + "." + s4);
					}
				}
			}
		}
		return res;
	}

	public boolean isValid(String s) {
		if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255)
			return false;
		return true;
	}
}
