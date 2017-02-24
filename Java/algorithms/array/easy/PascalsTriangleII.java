package array.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
	// Given an index k, return the kth row of the Pascal's triangle.
	// For example, given k = 3,
	// Return [1,3,3,1].

	public List<Integer> solution(int rowIndex) {
		//Your runtime beats 14.85% of java submissions. Runtime 3ms
		List<Integer> preLine = new ArrayList<>();
		preLine.add(1);

		for (int i = 0; i < rowIndex; i++) {
			List<Integer> posLine = new ArrayList<>();
			posLine.add(1);
			for (int j = 0; j < i; j++) {
				posLine.add(preLine.get(j) + preLine.get(j+1));
			}
			posLine.add(1);
			preLine = posLine;
		}

		return preLine;
	}
	
	
	public List<Integer> solution2(int rowIndex) {
		
		// !!More simple code
		// Your runtime beats 58.29% of java submissions. Runtime 2ms
		  List<Integer> res = new ArrayList<Integer>();
		    for(int i = 0;i<rowIndex+1;i++) {
		    		res.add(1);
		    		for(int j=i-1;j>0;j--) {
		    			res.set(j, res.get(j-1)+res.get(j));
		    		}
		    }
		    return res;
	}
}
	
