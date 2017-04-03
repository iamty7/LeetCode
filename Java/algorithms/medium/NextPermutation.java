package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class NextPermutation {
	/*
	 * Implement next permutation, which rearranges numbers into the
	 * lexicographically next greater permutation of numbers.
	 * 
	 * If such arrangement is not possible, it must rearrange it as the lowest
	 * possible order (ie, sorted in ascending order).
	 * 
	 * The replacement must be in-place, do not allocate extra memory.
	 * 
	 * Here are some examples. Inputs are in the left-hand column and its
	 * corresponding outputs are in the right-hand column.
	 * 
	 * 1,2,3 -> 1,3,2
	 * 3,2,1 -> 1,2,3
	 * 1,2,4,6,5,1 -> 1,2,5,1,4,6
	 */
	
	public void nextPermutation(int[] nums) {
		// Your runtime beats 52.85% of java submissions. Runtime 21ms
		int i = nums.length - 1;
		while (i > 0 && nums[i - 1] >= nums[i])
			i--;
		if (i > 0) {
			int j = i;
			while (j < nums.length && nums[j] > nums[i - 1])
				j++;
			int tmp = nums[i - 1];
			nums[i - 1] = nums[j - 1];
			nums[j - 1] = tmp;
			int left = i, right = nums.length - 1;
			while (left < right) {
				tmp = nums[left];
				nums[left] = nums[right];
				nums[right] = tmp;
				left++;
				right--;
			}
		} else {
			int left = 0, right = nums.length - 1;
			int tmp;
			while (left < right) {
				tmp = nums[left];
				nums[left] = nums[right];
				nums[right] = tmp;
				left++;
				right--;
			}
		}
	}

}
