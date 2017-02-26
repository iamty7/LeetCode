package hashTable.easy;

public class IntersectionOfTwoArraysII {
	/*
	 * Given two arrays, write a function to compute their intersection.
	 * 
	 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
	 * 
	 * Note: Each element in the result should appear as many times as it shows
	 * in both arrays. The result can be in any order.
	 * 
	 * Follow up: What if the given array is already sorted? How would you
	 * optimize your algorithm? What if nums1's size is small compared to
	 * nums2's size? Which algorithm is better? What if elements of nums2 are
	 * stored on disk, and the memory is limited such that you cannot load all
	 * elements into the memory at once?
	 */

	/*
	 * !!Explanation:
	 * Use LinkedList instead of Hashset compared to the last
	 * problem.
	 * 
	 * If the given arrays are already sorted than we can compare their elements
	 * one by one from the beginning(if equal than add). Or use binary search
	 * 
	 * If nums1's size is small compared to nums2's size, the binary-search
	 * method would be better.
	 * 
	 * If only nums2 cannot fit in memory, put all elements of nums1 into a
	 * HashMap, read chunks of array that fit into the memory, and record the
	 * intersections.
	 * 
	 * If both nums1 and nums2 are so huge that neither fit into the memory,
	 * sort them individually (external sort), then read 2 elements from each
	 * array at a time in memory, record intersections.
	 */

}
