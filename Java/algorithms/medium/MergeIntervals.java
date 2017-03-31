package medium;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
	/*
	 * Given a collection of intervals, merge all overlapping intervals.
	 * 
	 * For example, 
	 * Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
	 */

	public List<Interval> merge(List<Interval> intervals) {
		// Your runtime beats 7.22% of java submissions. Runtime 48ms
		if (intervals.size() <= 1)
			return intervals;

		intervals.sort(new IntervalsComparatorByStart());
		int start = intervals.get(0).start, end = intervals.get(0).end;
		for (int i = 0; i < intervals.size(); i++) {
			if (end < intervals.get(i).start) {
				intervals.add(i, new Interval(start, end));
				start = intervals.get(i + 1).start;
				end = intervals.get(i + 1).end;
				intervals.remove(i + 1);
				continue;
			}
			end = Math.max(end, intervals.get(i).end);
			intervals.remove(i);
			i--;
		}
		intervals.add(new Interval(start, end));
		return intervals;
	}

	public List<Interval> merge2(List<Interval> intervals) {
		// Your runtime beats 41.92% of java submissions. Runtime 30ms
		if (intervals.size() <= 1)
			return intervals;

		intervals.sort(new IntervalsComparatorByStart());
		List<Interval> results = new LinkedList<>();
		int start = intervals.get(0).start, end = intervals.get(0).end;
		for (Interval interval : intervals) {
			if (end < interval.start) {
				results.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
			end = Math.max(end, interval.end);
		}
		results.add(new Interval(start, end));
		return results;
	}

	class IntervalsComparatorByStart implements Comparator<Interval> {

		@Override
		public int compare(Interval o1, Interval o2) {
			if (o1.start < o2.start)
				return -1;
			if (o1.start > o2.start)
				return 1;
			return 0;
		}

	}

	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

}
