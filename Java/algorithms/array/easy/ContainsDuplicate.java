package array.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	
	//The two method have roughly same execution time about 12ms
	
	public boolean solution(int[] nums) {
		
		HashMap<Integer, Boolean> flagMap = new HashMap<>();
		
		for(int n:nums){
			if(flagMap.containsKey(n))
				return true;
			flagMap.put(n, true);
		}
		
 		return false;
	}
	
	
	public boolean solution2(int[] nums) {
		
		Set<Integer> numSet = new HashSet<>();
		
		for (int n:nums) {
			if(!numSet.add(n))
				return true;
		}
		
		return false;
 	}
}
