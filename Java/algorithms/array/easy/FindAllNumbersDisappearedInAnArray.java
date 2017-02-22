package array.easy;

import java.util.LinkedList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

	public List<Integer> solution(int[] nums) {

		// Your runtime beats 46.93% of java submissions. Runtime 18ms
		LinkedList dispNum = new LinkedList();
		
		for(int i = 0; i < nums.length; i++){
			nums[Math.abs(nums[i])-1] = - Math.abs(nums[Math.abs(nums[i])-1]);
		}
		
		
		for(int i = 0; i < nums.length; i++){
			if(nums[i]>0)
				dispNum.add(i+1);
				
		}
        return dispNum;    
    }
	
	
	
	
}
