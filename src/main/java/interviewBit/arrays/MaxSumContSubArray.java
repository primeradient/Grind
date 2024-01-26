package interviewBit.arrays;

import java.util.ArrayList;
import java.util.List;

public class MaxSumContSubArray {
    /**
     * Find the contiguous subarray within an array, A of length N which has the largest sum.
     *
     *
     * Problem Constraints
     * 1 <= N <= 106
     * -1000 <= A[i] <= 1000
     *
     *
     * Input Format
     * The first and the only argument contains an integer array, A.
     *
     *
     * Output Format
     * Return an integer representing the maximum possible sum of the contiguous subarray.
     */

    public int maxSubArray(final List<Integer> A) {
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        int start = 0, end = 0;

        for (int i = 0; i < A.size(); i++) {
            currSum += A.get(i);

            if ( currSum > maxSum) {
                maxSum = currSum;
                end = i;
            }

            if ( currSum < 0 && i + 1 < A.size()) {
                currSum = 0;
                start = i+1;
            }
        }

        System.out.println(">> MaxSUM = " + maxSum + " between " + start + " - " + end);

        return maxSum;
    }

    public static void main(String [] args) {
        int [] arr = new int[]{ -163, -20 };
        ArrayList<Integer> A = new ArrayList<>();
        for ( int val : arr) {
            A.add(val);
        }
        System.out.println(new MaxSumContSubArray().maxSubArray(A));
    }
}
