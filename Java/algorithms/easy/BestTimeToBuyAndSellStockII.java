package easy;

public class BestTimeToBuyAndSellStockII {
	/*
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times). However, you may not engage in multiple transactions at
	 * the same time (ie, you must sell the stock before you buy again).
	 */

	public int solution(int[] prices) {
		// Your runtime beats 65.38% of java submissions. Runtime 1ms
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])
				profit += prices[i] - prices[i - 1];
		}

		return profit;
	}
	// Wrong answer since it must buy the stock at the first day
	// public int solution(int[] prices) {
	//
	// if (prices.length == 0)
	// return 0;
	//
	// int maxProfit = 0;
	// int min = prices[0];
	// for (int i = 1; i < prices.length; i++) {
	// if (prices[i] > min) {
	// maxProfit += prices[i] - min;
	// min = prices[i];
	// }
	// }
	//
	// return maxProfit;

}
