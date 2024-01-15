package interviewBit.level2.arrays;

import java.util.ArrayList;

/**
 *
 * Problem Description
 *
 * Given an array A of size N. You need to find the sum of Maximum and Minimum element in the given array.
 *
 * NOTE: You should make minimum number of comparisons.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * -109 <= A[i] <= 109
 *
 */
public class MaxMinSum {

    public int solve(ArrayList<Integer> A) {

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int val : A) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        return (int)(max + min);
    }

    public static void main(String [] args) {
        int [] arr = new int[]{1, 3, 4, 1};
        ArrayList<Integer> A = new ArrayList<>();
        for ( int val : arr) {
            A.add(val);
        }
        System.out.println(new MaxMinSum().solve(A));

    }
}
