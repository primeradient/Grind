package interviewBit.level2.arrays;

import java.util.*;

/**
 *  This is not inception, but i did waste good amount of time on wasted logic.
 *
 * Given a set of non-overlapping intervals and a new interval.
 *
 * Insert the new interval into the set of intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 * Note: Make sure the returned intervals are also sorted.
 *
 *
 *
 * Problem Constraints
 * 0 <= |intervals| <= 106
 * 1 <= interval'i.start < interval'i.end <= 109
 * 1 <= newInterval.start < newInteval.end <= 109
 */
public class MergeIntervals {

    /* Algo
            1. Irrespective of overlap or non-overlap, add the newInterval to existing interval list
            2. Sort the interval list based on interval.start   (custom comparator)
            3. Push 1st interval in stack
            4. for all intervals from 1 to end
                   if ( stackTop.end < interval.start )
                          push(interval) in stack
                   else if ( stackTop.end < interval.end )
                         stackTop.end = interval.end
                         pop() stack
                         push(stackTop) into stack
            5. Return elements
     */

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        intervals.add(newInterval);

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval t1) {
                return interval.start - t1.start;
            }
        });


        Stack<Interval> stack = new Stack<>();
        stack.push(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval stackTop = stack.peek();

            if ( stackTop.end < intervals.get(i).start) {
                stack.push(intervals.get(i));
            } else if ( stackTop.end < intervals.get(i).end) {
                stackTop.end = intervals.get(i).end;
                stack.pop();
                stack.push(stackTop);
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            result.add(stack.get(i));
        }

        return result;
    }

    public static void main(String [] args) throws Exception {
        int [][] arr = new int[][]{{1,4}, {7,10},{14,17}};

        ArrayList<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            intervals.add(new Interval(arr[i][0], arr[i][1]));
        }


        System.out.println(new MergeIntervals().insert(intervals, new Interval(25,30)));
        System.out.println(new MergeIntervals().insert(intervals, new Interval(2,3)));
        System.out.println(new MergeIntervals().insert(intervals, new Interval(3,8)));
        System.out.println(new MergeIntervals().insert(intervals, new Interval(0,15)));
        System.out.println(new MergeIntervals().insert(intervals, new Interval(8,15)));
        System.out.println(new MergeIntervals().insert(intervals, new Interval(0,100)));
        System.out.println(new MergeIntervals().insert(intervals, new Interval(12,100)));

        System.out.println(new MergeIntervals().insert(intervals, new Interval(12,13)));
    }

    private static void validate(int [][]input,String expected, String actual) throws Exception {
        if ( !expected.equals(actual)) throw new Exception("Invalid comparision. Input:  " + Arrays.toString(input) + " => Expected: " + expected + ", Actual: " + actual);
    }
}


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return start + "," + end;
    }
}
