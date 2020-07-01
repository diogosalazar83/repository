package merge;

import java.util.*;

class IntervalsIntersection {

  public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
    List<Interval> intervalsIntersection = new ArrayList<Interval>();
    for (Interval current1 : arr1) {
    	for (Interval current2 : arr2) {
    		if (overlap(current1,current2)) {
    			intervalsIntersection.add(merged(current1, current2));
    		}
    	}
    }
    return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
  }
  
	private static boolean overlap(Interval int1, Interval int2) {
		return ((int1.start <= int2.start && int1.end >= int2.start) ||((int2.start <= int1.start && int2.end >= int1.start)));
	}

	private static Interval merged(Interval int1, Interval int2) {
		return new Interval(Math.max(int1.start, int2.start), Math.min(int1.end, int2.end));
	}

  public static void main(String[] args) {
    Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
    Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
    Interval[] result = IntervalsIntersection.merge(input1, input2);
    System.out.print("Intervals Intersection: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
    input2 = new Interval[] { new Interval(5, 10) };
    result = IntervalsIntersection.merge(input1, input2);
    System.out.print("Intervals Intersection: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + "," + interval.end + "] ");
  }
}

