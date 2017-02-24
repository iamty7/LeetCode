package array.easy;

public class TwoSumII_InputArrayIsSorted {
	/*
	 * Given an array of integers that is already sorted in ascending order,
	 * find two numbers such that they add up to a specific target number.
	 * 
	 * The function twoSum should return indices of the two numbers such that
	 * they add up to the target, where index1 must be less than index2. Please
	 * note that your returned answers (both index1 and index2) are not
	 * zero-based.
	 * 
	 * You may assume that each input would have exactly one solution and you
	 * may not use the same element twice.
	 * 
	 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
	 */
	public int[] solution(int[] numbers, int target) {
		// If the two target numbers are in the center of the array, it would be
		// quite inefficient, so look at No.2
		// Time Limit Exceeded
		int i = 0, j = numbers.length - 1;

		while (numbers[i] + numbers[j] != target) {
			if (numbers[i] + numbers[j] > target)
				--j;
			else if (numbers[i] + numbers[j] < target)
				++i;
		}
		return new int[] { i + 1, j + 1 };

	}

	public int[] solution2(int[] numbers, int target) {
		// Use a mid to get to the target faster
		// Your runtime beats 41.41% of java submissions. Runtime 1ms
		int i = 0, j = numbers.length - 1;

		while (numbers[i] + numbers[j] != target) {
			int mid = (i + j) / 2;
			if (numbers[i] + numbers[j] > target) {
				--j;
				if (numbers[mid] + numbers[i] > target) {
					j = mid - 1;
				}

			} else if (numbers[i] + numbers[j] < target)
				++i;
			if (numbers[mid] + numbers[j] < target) {
				i = mid + 1;
			}
		}
		return new int[] { i + 1, j + 1 };

	}

}
