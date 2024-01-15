package interviewBit.level2.arrays;

import java.util.*;

/**
 *
 Given an unsorted integer array, find the first missing positive integer.
 Your algorithm should run in O(n) time and use constant space.


 Problem Constraints
 1 <= |A| <= 106
 1 <= Ai <= 106

 so 0 is not a min. 1 is min. positive integer

 */
public class FirstMissingPositiveInteger {

    public int firstMissingPositiveSolutionFailsonHard(ArrayList<Integer> A) {
        int min = 1;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (  A.get(i) > 0 && min > A.get(i)) {
                min = A.get(i);
            }
            if ( A.get(i) > 0 &&  A.get(i) > max) {
                max = A.get(i);
            }
        }
        int missing = 1;
        for (int i = min; i <= max; i++) {
            if ( !A.contains(i)) {
                missing = i;
                break;
            }
        }
        return missing;

    }

    /** Good algo
     *
     * Sort the number list
     * Set expectedNumber as 1
     * for 0 to N
     *      ignore arr[i] <= 0
     *      if arr[i] != expectedNo,  return expectedNo
     *      else expectedNo++
     *
     */
    public int firstMissingPositive(ArrayList<Integer> A) {
        Collections.sort(A); //n logn
        int expectedNumber = 1;
        for (int i = 0; i < A.size(); i++) {
            if ( A.get(i) <= 0) continue;
            if ( A.get(i) == expectedNumber) {
                expectedNumber++;
            } else {
                break;
            }
        }
        return expectedNumber;

    }


    public static void main(String [] args) {
        //int [] arr = new int[] {3,4,-1,1}; //2
        //int [] arr = new int[] {1,2,0}; //3
        int [] arr = new int[] {-8,-7,-6}; //1


        ArrayList<Integer> A = new ArrayList<>();
        for (int val : arr) {
            A.add(val);
        }
        System.out.println(new FirstMissingPositiveInteger().firstMissingPositive(A));
    }
}
