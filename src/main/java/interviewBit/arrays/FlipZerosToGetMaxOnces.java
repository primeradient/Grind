package interviewBit.arrays;

import java.util.ArrayList;

/**
 * Problem Description
 *
 *
 *
 * You are given a binary string A(i.e. with characters 0 and 1) consisting of characters A1, A2, ..., AN.
 * In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping,
 * we mean change character 0 to 1 and vice-versa.
 *
 * Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised.
 *
 * If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R.
 * If there are multiple solutions, return the lexicographically smallest pair of L and R.
 *
 * NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
 *
 *  Problem Constraints
 * 1 <= size of string <= 100000

 * Input Format
 * First and only argument is a string A.
 *
 * Output Format
 * Return an array of integers denoting the answer.
 */

public class FlipZerosToGetMaxOnces {

    /** This turned out to be another iteration of Max Sum Subarray Problem
     *
     *  To solve this, we need to flip 0s to 1s so that there are max. 1s together
     *  To solve, consider value of 0 as Integer.1  and value of 1 as Integer.-1
     *
     *  No run it through maxSubArray for regular flow. Return back maxI and maxJ indexes that gives us maxSum
     *
     */

    public ArrayList<Integer> flip(String A) {
        final String empty = "";

        int maxSum = Integer.MIN_VALUE;
        int maxI = 0;
        int maxJ = 0;

        int i = 0;
        int currSum = 0;

        for (int j = 0; j < A.length(); j++) {
            int val = ( Integer.parseInt(A.charAt(j) + empty) == 0 ) ? 1 : -1;
            currSum = currSum + val;

            if ( currSum < 0 ) {
                currSum = 0;
                i = j + 1;
            }
            if ( currSum > maxSum && currSum != 0) {
                maxI = i;
                maxJ = j;
                maxSum = currSum;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        if ( maxSum != Integer.MIN_VALUE) {
            result.add(maxI + 1);
            result.add(maxJ + 1);
        }

        return result;

    }


    public static void main(String args[]) {
        System.out.println(new FlipZerosToGetMaxOnces().flip("111"));
    }
}
