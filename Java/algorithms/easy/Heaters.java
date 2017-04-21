package easy;

import java.util.Arrays;

public class Heaters {
	/*
	 * Winter is coming! Your first job during the contest is to design a
	 * standard heater with fixed warm radius to warm all the houses.
	 * 
	 * Now, you are given positions of houses and heaters on a horizontal line,
	 * find out minimum radius of heaters so that all houses could be covered by
	 * those heaters.
	 * 
	 * So, your input will be the positions of houses and heaters seperately,
	 * and your expected output will be the minimum radius standard of heaters.
	 * 
	 * Note: Numbers of houses and heaters you are given are non-negative and
	 * will not exceed 25000. Positions of houses and heaters you are given are
	 * non-negative and will not exceed 10^9. As long as a house is in the
	 * heaters' warm radius range, it can be warmed. All the heaters follow your
	 * radius standard and the warm radius will the same. Example 1: Input:
	 * [1,2,3],[2] Output: 1 Explanation: The only heater was placed in the
	 * position 2, and if we use the radius 1 standard, then all the houses can
	 * be warmed. Example 2: Input: [1,2,3,4],[1,4] Output: 1 Explanation: The
	 * two heater was placed in the position 1 and 4. We need to use radius 1
	 * standard, then all the houses can be warmed.
	 */

	public int findRadius(int[] houses, int[] heaters) {
		// Your runtime beats 86.66% of java submissions. Runtime 21ms
		Arrays.sort(houses);
		Arrays.sort(heaters);
		int ret = 0;
		int curHeater = 0;
		int nextHeater = heaters.length >= 2 ? 1 : Integer.MAX_VALUE;
		for (int i = 0; i < houses.length; i++) {
			while (nextHeater != Integer.MAX_VALUE && houses[i] >= heaters[nextHeater]) {
				curHeater = nextHeater;
				nextHeater = nextHeater + 1 < heaters.length ? nextHeater + 1 : Integer.MAX_VALUE;
			}
			if (houses[i] < heaters[curHeater]) {
				ret = heaters[curHeater] - houses[i];
				while (i < houses.length && houses[i] < heaters[curHeater])
					i++;
				i--;
				continue;
			}
			ret = Math.max(ret,
					nextHeater != Integer.MAX_VALUE
							? Math.min(heaters[nextHeater] - houses[i], houses[i] - heaters[curHeater])
							: houses[i] - heaters[curHeater]);
		}
		return ret;
	}

	public int findRadius2(int[] houses, int[] heaters) {
		// !!
		// Your runtime beats 90.20% of java submissions. Runtime 20ms
		Arrays.sort(houses);
		Arrays.sort(heaters);
		if (heaters.length == 1)
			return Math.max(Math.abs(houses[0] - heaters[0]), Math.abs(houses[houses.length - 1] - heaters[0]));
		int ret = 0;
		int i = 0;
		for (int house : houses) {
			// heaters[i] + heaters[i + 1] <= house * 2
			// is checking if house is closer to heaters[i] or heaters[i + 1]
			while (i + 1 < heaters.length && heaters[i] + heaters[i + 1] <= house * 2)
				i++;
			ret = Math.max(ret, Math.abs(house - heaters[i]));
		}
		return ret;
	}
}
