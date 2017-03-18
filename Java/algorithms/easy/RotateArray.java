package easy;

public class RotateArray {

	//Why the first is once more faster than the second considering it has fewer assignment process
	
	public void solution(int[] nums, int k) {

		// Your runtime beats 13.80% of java submissions. Runtime 1ms
		
		if(nums.length==1 || k == 0)
			return;
		
		k = k % nums.length;
		
		int[] tmp = new int[nums.length];
		
		for (int i = 0; i < nums.length; i++) {
			tmp[(i + k) % nums.length] = nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = tmp[i];
		}
	}

	
	public void solution2(int[] nums, int k) {
		
		// Your runtime beats 4.58% of java submissions. Runtime 2ms
		if(nums.length==1 || k == 0)
			return;
		
		k = k % nums.length;
		int[] tmp = new int[k];
		int j = 0;
		for(int i = nums.length-k;i<nums.length;i++){
			tmp[j++] = nums[i];
		}
		
		for (int i = nums.length-k-1; i >-1; i--) {
			nums[i+k] = nums[i];
		}
		
		--j;
		for(;j>-1;j--){
			nums[j] = tmp[j];
		}
		
	}
}
