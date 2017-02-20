package array.easy;


public class RemoveDuplicatesfromSortedArray {

	public int solution(int[] nums) {
		
		//是否存在连续两个相同的数字被i++跳过的情况？
		int len = nums.length;
		int pos = 0;
		int dupNum = 0;
		int i = 0;

		if(len == 0)
			return 0;
		if(len == 1)
			return 1;
		
		if(nums[len-1]==nums[len-2] && pos!=i-1)
			dupNum++;
		
		while (i<nums.length-1) {
			while (i<nums.length-2 && nums[i]==nums[i+1]) {
				i++;
				dupNum++;
			}
			pos++;
			i++;
			nums[pos] = nums[i];

		}
		

		
		return len - dupNum;
	}
}
