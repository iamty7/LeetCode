package array.easy;

import java.util.LinkedList;

import com.sun.org.apache.regexp.internal.recompile;

public class ThirdMaximumNumber {

	
	public int solution(int[] nums) {
		
//		if(nums.length == 1)
//			return nums[0];
//		if(nums.length == 2)
//			return nums[0]>nums[1]?nums[0]:nums[1];

		int max = -2147483648, 
			mid = -2147483648, 
			min = -2147483648,
			flag = 0;
//		LinkedList<Integer> linkedList = new LinkedList<>();
//		for (int i = 0; i < nums.length; i++) {
//			linkedList.add(nums[i]);
//		}
//		
//		int pointer = linkedList.getFirst();
//		for (Integer integer : linkedList) {
//			if (integer > pointer) {
//				pointer = integer;
//				linkedList.remove(integer);
//			}
//		}
//		min = pointer;
//		
//		
//		pointer = linkedList.getFirst();
//		for (Integer integer : linkedList) {
//			if (integer > pointer) {
//				pointer = integer;
//				linkedList.remove(integer);
//			}
//		}
//		if(pointer!=)

		for (int i = 0; i < nums.length; i++) {
			if(nums[i]>=max)
				max = nums[i];
		}
		
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]>=mid && nums[i]!=max)
				mid = nums[i];
			
		}
		
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]>=min && nums[i]!=max && nums[i]!=mid){
				min = nums[i];
				flag=1;
			}
		}
		
		if(flag==1)
			return min;
		else 
			return max;
		
	}
	
	

		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();
		System.out.println(thirdMaximumNumber.solution(new int[] {1,2,-2147483648}));
	}

}
