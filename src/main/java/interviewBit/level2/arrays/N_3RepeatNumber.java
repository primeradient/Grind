package interviewBit.level2.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
 If so, return the integer. If not, return -1.

 If there are multiple solutions, return any one.

 Problem Constraints
 1 <= N <= 7*105
 1 <= A[i] <= 109


 Output Format:  Return an integer.
*/


public class N_3RepeatNumber {
    /* this is following moore voting algo to find majority element.
       We track two indexes which can be majority and decide from any one of them
     */

    public int repeatedNumber(final List<Integer> A) {
        int majority1 = Integer.MIN_VALUE;
        int majority2 = Integer.MAX_VALUE;
        int count1 = 1, count2 = 1;

        if ( A.size() == 0) return -1;
        if ( A.size() == 1) return A.get(0);

        for (int i = 0; i < A.size(); i++) {
            if ( A.get(i) == majority1) {
                count1++;
            } else if ( A.get(i) == majority2) {
                count2++;
            } else if ( count1 == 0) {
                count1 = 1;
                majority1 = A.get(i);
            } else if( count2 == 0) {
                count2 = 1;
                majority2 = A.get(i);
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        // Again traverse the array and
        // find the actual counts.
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == majority1)
                count1++;

            else if (A.get(i) == majority2)
                count2++;
        }

        if (count1 > A.size() / 3)
            return majority1;

        if (count2 > A.size() / 3)
            return majority2;

        return -1;
    }


    public static void main(String [] args) {
        int []arr = new int[] { 1000441, 1000441, 1000994};
        ArrayList<Integer> A = new ArrayList<>();
        for ( int val : arr) {
            A.add(val);
        }
        System.out.println(new N_3RepeatNumber().repeatedNumber(A));
    }
}
