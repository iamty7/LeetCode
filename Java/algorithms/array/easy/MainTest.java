package array.easy;

import java.util.Arrays;

public class MainTest {

	public static void main(String[] args) {
		
		int res;
		int[] nums ={0,1,4,3,5,2,7,8};
		MissingNumber missingNumber = new MissingNumber();
	
		//�����������ķ�ʽ
//		for (int i : moveZeroes.solution(nums)) {
//			System.out.println(i);
//		}
		long startTime = System.nanoTime();
		res = missingNumber.solution2(nums);
		long endTime = System.nanoTime();
		System.out.println(res);
		System.out.println("��������ʱ��: "+(endTime-startTime)+"ns");
		
		
	}

}
