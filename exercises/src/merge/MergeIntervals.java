package merge;

import java.util.*;

class Interval {
	int start;
	int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public boolean equals(Interval other) {
		return (this.start == other.start && this.end == other.end);
	}
};

class IntervalComparator implements Comparator<Interval>{

	@Override
	public int compare(Interval o1, Interval o2) {
		int calc = o1.start-o2.start;
		if (calc == 0) {
			return o1.end-o2.end;
		}
		return calc;
	}

};

class MergeIntervals {

	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> mergedIntervals = new LinkedList<Interval>();
		for (Interval current : intervals) {
			Interval temp = null;
			for (Interval current2 : intervals) {
				if (temp == null && overlap(current, current2)) {
					temp = merge(current, current2);
				} else if (temp != null && overlap(current, current2)) {
					temp = merge(temp, current2);
				}
			}//end of second for
			if (temp != null && !contain(mergedIntervals, temp)) {
				mergedIntervals.add(temp);
			} 
		}//end of first for
		return mergedIntervals;
	}

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		intervals.add(newInterval);
		intervals.sort(new IntervalComparator());
		return merge(intervals);
	}

	private static boolean contain(List<Interval> mergedIntervals, Interval temp) {
		Iterator<Interval> iterator = mergedIntervals.iterator();
		while (iterator.hasNext()) {
			Interval next = iterator.next();
			if (next.equals(temp)) {
				return true;
			}
			if (overlap(next, temp)) {
				return true;
			}
		}
		return false;
	}

	private static boolean overlap(Interval int1, Interval int2) {
		return ((int1.start <= int2.start && int1.end >= int2.start) ||((int2.start <= int1.start && int2.end >= int1.start)));
	}

	private static Interval merge (Interval int1, Interval int2) {
		return new Interval(Math.min(int1.start, int2.start), Math.max(int1.end, int2.end));
	}

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : MergeIntervals.insert(input, new Interval(4, 6)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : MergeIntervals.insert(input, new Interval(4, 10)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(2, 3));
		input.add(new Interval(5, 7));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : MergeIntervals.insert(input, new Interval(1, 4)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();
	}
}
