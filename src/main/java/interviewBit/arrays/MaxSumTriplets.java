package interviewBit.arrays;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 *    Given an array A containing N integers.
 *
 *    You need to find the maximum sum of triplet ( Ai + Aj + Ak ) such that 0 <= i < j < k < N and Ai < Aj < Ak.
 *
 *     If no such triplet exist return 0.
 */

public class MaxSumTriplets {


    public int solve(ArrayList<Integer> A) {
        int maxSum = Integer.MIN_VALUE;

        //we create array which tracks max. number to the right
        int [] maxRight = new int[A.size()];
        maxRight[A.size()-1] = A.get(A.size()-1);
        for (int i = A.size()-2; i >= 0 ; i--) {
            maxRight[i] = Math.max(maxRight[i+1], A.get(i));
        }

        //Now, we can't do the same with left side min, as we want max number minimum than every position number
        //One way to do so is to sort all the numbers to the left and find the maximum number using binary search
        //in Java, we can use TreeSet<> to keep things sorted and
        // function "lower()", which would give lowest(min) closed to input number

        TreeSet<Integer> maxLeft = new TreeSet<>();
        maxLeft.add(Integer.MIN_VALUE);

        for(int i = 0; i < A.size()-1; ++i) {
            if (maxRight[i] > A.get(i))    {
                maxSum = Math.max(maxSum, maxLeft.lower(A.get(i)) + A.get(i) + maxRight[i]);
                maxLeft.add( A.get(i));
            }
        }
        return maxSum;


    }


    public static void main(String []args) {
        int [] arr = new int[]{2, 5, 3, 1, 4, 9};
        ArrayList<Integer> A = new ArrayList<>();
        for ( int i : arr) {
            A.add(i);
        }
        System.out.println(new MaxSumTriplets().solve(A));
    }
}
