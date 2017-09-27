package medium;

public class SearchInRotatedSortedArray {
	/*
	 * Suppose an array sorted in ascending order is rotated at some pivot
	 * unknown to you beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * You are given a target value to search. If found in the array return its
	 * index, otherwise return -1.
	 * 
	 * You may assume no duplicate exists in the array.
	 * 
	 */
	
	
	public int solution1(int[] A, int target) {
		// Your runtime beats 6.75 % of java submissions. Runtime 19ms
		if (A.length == 0)
			return -1;

		int left = 0, right = A.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (A[mid] >= A[left]) {
				if (A[mid] <= target) {
					left = mid;
				} else if (target >= A[left]) {
					right = mid;
				} else {
					left = mid;
				}
			} else {
				if (target >= A[left]) {
					right = mid;
				} else if (target > A[mid]) {
					left = mid;
				} else
					right = mid;
			}

		}

		if (A[left] == target)
			return left;
		else if (A[right] == target)
			return right;
		else
			return -1;
	}

	public int solution2(int[] A, int target) {
		// same idea but more consice than solution 1
		// Your runtime beats 56.06 % of java submissions. Runtime 14ms
		if (A == null || A.length == 0) {
			return -1;
		}

		int start = 0;
		int end = A.length - 1;
		int mid;

		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			}
			if (A[start] < A[mid]) {
				// situation 1, red line
				if (A[start] <= target && target <= A[mid]) {
					end = mid;
				} else {
					start = mid;
				}
			} else {
				// situation 2, green line
				if (A[mid] <= target && target <= A[end]) {
					start = mid;
				} else {
					end = mid;
				}
			}
		} // while

		if (A[start] == target) {
			return start;
		}
		if (A[end] == target) {
			return end;
		}
		return -1;
	}

	// solution 3: Use two binary search, one to find the pivot index, the other
	// to search the target
}
