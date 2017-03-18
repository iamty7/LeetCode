package easy;

public class PlusOne {

	public int[] solution(int[] digits) {

		// Your runtime beats 7.81% of java submissions. Runtime 1ms
		if (digits[0] == 0) {
			++digits[0];
			return digits;
		}

		for (int i = digits.length - 1; i > -1; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
				continue;
			}
			++digits[i];
			break;
		}

		if (digits[0] == 0) {
			int[] newDigits = new int[digits.length + 1];
			newDigits[0] = 1;
			return newDigits;
		}

		return digits;
	}

	public int[] simplfiedSolution(int[] digits) {
		// Your runtime beats 45.20% of java submissions. Runtime 0ms
		// This method is the same as above
		for (int i = digits.length - 1; i > -1; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
				continue;
			}
			++digits[i];
			return digits;
		}

		int[] newDigits = new int[digits.length + 1];
		newDigits[0] = 1;
		return newDigits;
	}

}
