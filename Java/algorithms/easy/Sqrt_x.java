package easy;

public class Sqrt_x {
	/*
	 * Implement int sqrt(int x). Compute and return the square root of x.
	 */

	public int mySqrt(int x) {
		// binary search
		// Your runtime beats 21.34% of java submissions. Runtime 3ms
		if (x == 0)
			return 0;
		int left = 1, right = Integer.MAX_VALUE;
		while (true) {
			// use minus instead of add to avoid overflow
			int mid = left + (right - left) / 2;
			// avoid overflow
			if (mid > x / mid) {
				right = mid - 1;
			} else {
				if (mid + 1 > x / (mid + 1))
					return mid;
				left = mid + 1;
			}
		}
	}
}
