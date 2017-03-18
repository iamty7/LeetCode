package easy;

import java.util.HashSet;

public class HappyNumber {
	/*
	 * Write an algorithm to determine if a number is "happy".
	 * 
	 * A happy number is a number defined by the following process: Starting
	 * with any positive integer, replace the number by the sum of the squares
	 * of its digits, and repeat the process until the number equals 1 (where it
	 * will stay), or it loops endlessly in a cycle which does not include 1.
	 * Those numbers for which this process ends in 1 are happy numbers.
	 * 
	 * Example: 19 is a happy number
	 * 
	 * 1^2 + 9^2 = 82 8^2 + 2^2 = 68 6^2 + 8^2 = 100 1^2 + 0^2 + 0^2 = 1
	 */

	public boolean solution(int n) {
		// Your runtime beats 10.08% of java submissions. Runtime 7ms
		HashSet<Integer> preNum = new HashSet<>();
		if (n < 1)
			return false;

		while (true) {
			if (n == 1)
				return true;
			if (preNum.contains(n))
				return false;
			preNum.add(n);
			int sumSquare = 0;
			while (n > 0) {
				int dig = (n % 10);
				sumSquare += dig * dig;
				n /= 10;
			}
			n = sumSquare;

		}
	}

	public boolean solution2(int n) {
		// !!If the loop range is not very big and the process is relatively
		// long we can use two pointer to detect the loop
		// Your runtime beats 82.52% of java submissions. Runtime 2ms
		if (n < 1)
			return false;

		int num1 = n, num2 = n;
		do {
			num1 = next(num1);
			num2 = next(num2);
			num2 = next(num2);
		} while (num1 != num2);

		if (num1 != 1)
			return false;
		return true;

	}

	public int next(int n) {
		int sumSquare = 0;
		while (n > 0) {
			int dig = (n % 10);
			sumSquare += dig * dig;
			n /= 10;
		}
		return sumSquare;
	}
}
