package array.easy;

import java.util.HashMap;

public class ContainsDuplicate {
	public boolean solution(int[] nums) {
		
		HashMap<Integer, Boolean> flagMap = new HashMap<>();
		
		for(int n:nums){
			if(flagMap.containsKey(n))
				return true;
			flagMap.put(n, true);
		}
		
 		return false;
	}
}
