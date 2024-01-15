package interviewBit.level2.arrays;

import java.util.ArrayList;
/*

Problem Description



Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted.
If A is already sorted, output -1.



Problem Constraints
1 <= N <= 1000000

1 <= A[i] <= 1000000


 */
public class MaximumUnsortedSubarray {

    /*
        Logic:
            1. From 0 to N, find left such that it violates less than order with next element
            2. From N to 0, find left such that it violates greater than order with prev element
            3. Check if left >= right, exit
            4. Between left and right, find min and max values
            5. Adjust left to position where arr[] > min (from 0 to left-1)
            6. Adjust right to position where arr[] > man (from right+1 to N)
            7. Check if left >= right, exit
     */
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();

        if ( A.size() == 0) {
            result.add(-1);
            return  result;
        }

        int right = A.size()-1;
        for (; right > 0 ; right--) {
            if ( A.get(right) < A.get(right-1) ) break;
        }

        int left = 0;
        for (; left< A.size()-1;left++) {
            if ( A.get(left) > A.get(left+1) ) break;
        }

        if ( left >= right ) {
            result.add(-1);
            return result;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = left; i <= right; i++) {
            if  ( A.get(i) < min) {
                min = A.get(i);
            }
            if ( A.get(i) > max) {
                max = A.get(i);
            }
        }


        for (int i = 0; i < left; i++) {
            if ( A.get(i) > min) {
                left = i;
                break;
            }
        }

        for (int i = A.size()-1; i >  right; i--) {
            if ( A.get(i) < max) {
                right = i;
                break;
            }
        }

        while ( right < A.size()-2) {
            if ( A.get(right) != A.get(right+1)) break;
            right++;
        }


        if ( left >= right ) {
            result.add(-1);
            return result;
        }

        result.add(left);
        result.add(right);


        return result;
    }

    public static void main(String [] args) {
        int [] arr = new int[] {1, 2, 3, 5, 6, 13, 15, 16, 17, 13, 13, 15, 17, 17, 17, 17, 17, 19, 19}; //6, 11
        //int [] arr = new int[] {1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15 }; //4,10
        //int [] arr = new int[] {4, 15, 4, 4, 15, 18, 20}; //1,3
        //int [] arr = new int[]{1, 1, 2, 3, 3, 4, 8, 9, 11, 9, 11, 12, 12, 11, 9, 14, 19, 20, 20}; //8,14
        //int [] arr = new int[]{ 4, 15, 4, 4, 15, 18, 20};
        //int [] arr = new int[]{ 1, 2, 3, 5, 6, 13, 15, 16, 17, 13, 13, 15, 17, 17, 17, 17, 17, 19, 19}; //6,11

        ArrayList<Integer> A = new ArrayList<>();
        for (int val : arr) {
            A.add(val);
        }
        ArrayList<Integer> res = new MaximumUnsortedSubarray().subUnsort(A);
        for (int val : res ) {
            System.out.print( " " + val);
        }
    }

}
