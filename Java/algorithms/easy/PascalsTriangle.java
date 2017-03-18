package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public List<List<Integer>> solution(int numRows) {
		// Your runtime beats 28.67% of java submissions. Runtime 1ms
		List<List<Integer>> tri = new ArrayList<>();
		List<Integer> preLine = new ArrayList<>();
		preLine.add(1);

		if (numRows == 0)
			return tri;

		tri.add(preLine);

		for (int i = 2; i < numRows + 1; i++) {
			List<Integer> posLine = new ArrayList<>();
			posLine.add(1);
			for (int j = 1; j < i - 1; j++) {
				posLine.add(preLine.get(j - 1) + preLine.get(j));
			}
			posLine.add(1);
			tri.add(posLine);
			preLine = posLine;
		}

		return tri;
	}
}