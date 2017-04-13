package medium;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	/*
	 * The gray code is a binary numeral system where two successive values
	 * differ in only one bit.
	 * 
	 * Given a non-negative integer n representing the total number of bits in
	 * the code, print the sequence of gray code. A gray code sequence must
	 * begin with 0.
	 * 
	 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is: 00
	 * - 0 01 - 1 11 - 3 10 - 2 Note: For a given n, a gray code sequence is not
	 * uniquely defined.
	 * 
	 * For example, [0,2,3,1] is also a valid gray code sequence according to
	 * the above definition.
	 * 
	 * For now, the judge is able to judge based on one instance of gray code
	 * sequence. Sorry about that.
	 */

	public List<Integer> grayCode(int n) {
		// Your runtime beats 16.81% of java submissions. Runtime 2ms
		List<Integer> list = new ArrayList<>();
		list.add(0);
		if (n == 0)
			return list;
		list.add(1);
		for (int i = 1; i < n; i++) {
			for (int j = list.size() - 1; j >= 0; j--) {
				list.add(list.get(j) + (1 << i));// (int) Math.pow(2, i)
			}
		}
		return list;
	}

	public List<Integer> grayCode2(int n) {
		// ??
		// Your runtime beats 46.60% of java submissions. Runtime 1ms
		List<Integer> result = new ArrayList();
		for (int i = 0; i < 1 << n; i++)
			result.add(i ^ i >> 1);
		return result;
	}
}
