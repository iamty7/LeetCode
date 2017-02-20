package array.easy;

import java.lang.reflect.Array;


public class MissingNumber {

	public int solution(int[] nums) {
		
		//XOR
		int xor = 0,
			i = 0;
		
		for (i = 0; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
		}
		
		return xor ^ i;
		
	}
	
	
	public int solution2(int[] nums) {
		
		//Gauss' Math Method or Sum
		int len = nums.length;
		
		int sum = (0+len)*(len+1)/2;
		int sumOfNums = 0;
		
		for (int i = 0; i < nums.length; i++) {
			sumOfNums+=nums[i];
		}
		
		return sum - sumOfNums;
	}
	
}
