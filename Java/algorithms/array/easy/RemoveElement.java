package array.easy;

public class RemoveElement {
	public int solution(int[] nums, int val) {
		
		int i = 0;
		for(int n:nums){
			if(n!=val)
				nums[i++] = n;
		}
		
		return i;
	}
}