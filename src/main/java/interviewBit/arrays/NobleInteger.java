package interviewBit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p.
 *
 *
 *
 * Problem Constraints
 *      1 <= |A| <= 106
 *   -109 <= Ai <= 109
 *
 *
 * Input Format
 * First and only argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return 1 if any such integer p is found else return -1
 *
 */

public class NobleInteger {

    /**
     *  What to watch out is duplicates
     *  ex. 3, 2, 4, 4
     *
     *  here at value=2,  there are 2 numbers > 2 in list
     *
     *  similarly
     *
     *  ex. 3, 2, 2, 4, 4
     *  here at 1st 2, there is no solution
     *  but at  2nd 2, there are 2 numbers > 2 in list
     *
     *
     *  Sort the list first
     *
     */

    public int solve(ArrayList<Integer> A) {
        int status = -1;

        Collections.sort(A);


        for (int i = 0; i < A.size(); i++) {
            int val = A.get(i);
            while ( i+1 < A.size() && val == A.get(i+1) ) {
                i++;
            }

            int diff = A.size()- (i+1);
            if ( val == diff) {
                return 1;
            }
        }

        return status;
    }



    public static void main(String [] args) {
        //int [] arr = new int[]{ -4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1, -8, 0, -8, -7, -3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6, 7, 8, -6, 5, 0, 3, -4, 1, -10, 6, 3, -8, 0, 6, -9, -5, -5, -6, -3, 6, -5, -4, -1, 3, 7, -6, 5, -8, -5, 4, -3, 4, -6, -7, 0, -3, -2, 6, 8, -2, -6, -7, 1, 4, 9, 2, -10, 6, -2, 9, 2, -4, -4, 4, 9, 5, 0, 4, 8, -3, -9, 7, -8, 7, 2, 2, 6, -9, -10, -4, -9, -5, -1, -6, 9, -10, -1, 1, 7, 7, 1, -9, 5, -1, -3, -3, 6, 7, 3, -4, -5, -4, -7, 9, -6, -2, 1, 2, -1, -7, 9, 0, -2, -2, 5, -10, -1, 6, -7, 8, -5, -4, 1, -9, 5, 9, -2, -6, -2, -9, 0, 3, -10, 4, -6, -6, 4, -3, 6, -7, 1, -3, -5, 9, 6, 2, 1, 7, -2, 5 };
        int []arr = new int[] { 3, 2, 1, 3};
        //int [] arr = new int[] {-1, -2, 0, 0, 0, -3 }; //-3 -2 -1 0
        //int [] arr = new int[] { 4, -9, 8, 5, -1, 7, 5, 3}; //-9 -1 3 4 5 5 7 8

        ArrayList<Integer> A = new ArrayList<>();
        for ( int val : arr) {
            A.add(val);
        }
        System.out.println(new NobleInteger().solve(A));

    }

}
