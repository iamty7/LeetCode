package array.easy;

import java.util.HashMap;



public class TwoSum {

	public  int[] solution(int[] nums, int target){
		
		HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++){
			myMap.put(nums[i],i);
		}

		for (int i = 0; i < nums.length; i++) {
			int resVal = target - nums[i];
			int anotherIndex = -1;
			if ( myMap.containsKey(resVal) && (anotherIndex = myMap.get(resVal))!= i) {
				return new int[]{i,anotherIndex};
			}
//			if (i < anotherIndex) {
//				results[0] = i;
//				results[1] = anotherIndex;
//				break;
//			}
//			if (i > anotherIndex) {
//				results[1] = i;
//				results[0] = anotherIndex;
//				break;
//			}
			

		}
		throw new IllegalArgumentException("No two sum solution");
		
	}
	
	public static int[] solution_2(int[] nums, int target){
		 HashMap<Integer, Integer> map = new HashMap<>();
		 for (int i = 0; i < nums.length; i++) {
		       int complement = target - nums[i];
		        if (map.containsKey(complement)) {
		            return new int[] { map.get(complement), i };
		        }
		        map.put(nums[i], i);
		    }
		    throw new IllegalArgumentException("No two sum solution");
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {2,7,11,15};
		TwoSum twoSum = new TwoSum();

		long startTime;   //获取开始时间  
		long endTime; //获取结束时间  
		int[] result;
		
		startTime=System.nanoTime();   //获取开始时间  
		result = twoSum.solution(nums,17);
		endTime=System.nanoTime(); //获取结束时间  
		System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
		
		
		System.out.println("["+result[0]+","+result[1]+"]");
	}

}
