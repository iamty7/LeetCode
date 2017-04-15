package easy;

public class ArrangingCoins {
	/*
	 * You have a total of n coins that you want to form in a staircase shape,
	 * where every k-th row must have exactly k coins.
	 * 
	 * Given n, find the total number of full staircase rows that can be formed.
	 * 
	 * n is a non-negative integer and fits within the range of a 32-bit signed
	 * integer.
	 * 
	 * Example 1:n = 5
	 * The coins can form the following rows: 
	 * ¤ 
	 * ¤ ¤ 
	 * ¤ ¤
	 * Because the 3rd row is incomplete, we return 2. 
	 * 
	 * Example 2:n = 8
	 * The coins can form the following rows: 
	 * ¤ 
	 * ¤ ¤ 
	 * ¤ ¤ ¤ 
	 * ¤ ¤
	 * Because the 4th row is incomplete, we return 3.
	 */
	
	public int arrangeCoins(int n) {
		// use float to avoid overflow
		// Your runtime beats 42.48% of java submissions. runtime 55ms
		if (n <= 0)
			return 0;
		int end = (int) Math.sqrt((double) 2 * n);
		if (((double) (1 + end) * (end) / 2) > n)
			return end - 1;
		else
			return end;
	}

	public int arrangeCoins2(int n) {
		// (1+x)*x/2=n -> x=(-1+sqrt(1+8n))/2
		// Your runtime beats 54.54% of java submissions. Runtime 52ms
		return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
	}
}
