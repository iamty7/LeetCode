package array.easy;

import jdk.nashorn.internal.ir.Flags;

public class MoveZeroes {

	
	public void solution(int[] nums) {
		int i = 0,
			j = 0;

		while(j<nums.length && nums[j]!=0)//!!把判断边界放在左边，防止角标越界
			j++;
		
		for(i=j;i<nums.length;i++){
			if(nums[i]!=0)
				continue;
			
			while(j<nums.length){
				if(nums[j]==0){
					j++;
					continue;
				}
				nums[i] = nums[j];
				nums[j] = 0;
				if(j == nums.length-1)
					return;
				j++;
				break;
			}
		}
		
	}
	
	/*Why the second one is better than the first 
	 * one when the array is relatively long
	 */
	public void solution2(int[] nums) {
		 if (nums == null || nums.length == 0) return;        

		    int insertPos = 0;
		    for (int num: nums) {
		        if (num != 0) nums[insertPos++] = num;
		    }        

		    while (insertPos < nums.length) {
		        nums[insertPos++] = 0;
		    }
	}
	
	

}
