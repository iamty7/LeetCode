package easy;

public class ClimbingStairs {
	/*
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 * 
	 * Each time you can either climb 1 or 2 steps. In how many distinct ways
	 * can you climb to the top?
	 * 
	 * Note: Given n will be a positive integer.
	 */

	public int climbStairs(int n) {
		// Your runtime beats 14.45% of java submissions. Runtime 0ms
		int[] subWays = new int[n + 1];
		subWays[0] = 1;
		subWays[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			subWays[i] = subWays[i - 2] + subWays[i - 1];
		}

		return subWays[n];
	}

	public int climbStairs2(int n) {
		/*
		 * Same simple algorithm written in every offered language. Variable a
		 * tells you the number of ways to reach the current step, and b tells
		 * you the number of ways to reach the next step. So for the situation
		 * one step further up, the old b becomes the new a, and the new b is
		 * the old a+b, since that new step can be reached by climbing 1 step
		 * from what b represented or 2 steps from what a represented.
		 */
		// Your runtime beats 14.45% of java submissions. Runtime 0ms
		
		int a = 1, b = 1;
		while (n-- > 0)
			a = (b += a) - a;
		return a;
	}
}
