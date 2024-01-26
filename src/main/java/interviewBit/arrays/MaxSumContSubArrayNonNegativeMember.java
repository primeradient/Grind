package interviewBit.arrays;

import java.util.ArrayList;

public class MaxSumContSubArrayNonNegativeMember {

    /*
    Problem Description:
        Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
        The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
        Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
        Find and return the required subarray.

    NOTE:
        If there is a tie, then compare with segment's length and return segment which has maximum length.
        If there is still a tie, then return the segment with minimum starting index.

    Problem Constraints
    1 <= N <= 10^5
    -10^9 <= A[i] <= 10^9

   */


    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int currI = 0, currJ = 0;
        int maxI = 0, maxJ = 0;
        long currSum = 0;
        long maxSum =  Long.MIN_VALUE;

        for (int i = 0; i < A.size(); i++) {
            currSum += A.get(i);
            if (currSum < 0 || A.get(i) < 0) {
                currSum = 0;
                currI= i+1;
            } else if ( currSum > maxSum ||  (currSum == maxSum && currJ-currI >= maxJ-maxI)) {
                maxSum = currSum;
                maxI = currI;
                maxJ = currJ;
            }
            currJ++;
        }
        if ( maxSum != Integer.MIN_VALUE) {
            for (int i = maxI; i <= maxJ; i++) {
                ret.add(A.get(i));
            }
        }
        return ret;
    }

    public static void main(String args[]) {
        //int []val = new int[]{25150, 1412, 82797, 48381, 7065, -47699, -25129, -65483, -64607, -45322, -55176, 27224, 80366, 60444, 70285, -93898, -41133, 96576, -58266, 21711, -20614, -95737, 20591, -48762, -76197, -38588, -54873, 37304, 61200, -68960, 93947};
        int []val = new int[]{0,0,-1,0};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i : val) {
            A.add(i);
        }
        new MaxSumContSubArrayNonNegativeMember().maxset(A);
    }
}
