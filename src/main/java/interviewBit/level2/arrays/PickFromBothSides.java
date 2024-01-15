package interviewBit.level2.arrays;

import java.util.ArrayList;

public class PickFromBothSides {

    /**
     * Given an integer array A of size N.
     * * You have to pick exactly B elements from either left or right end of the array A to get the maximum sum.
     *
     * Find and return this maximum possible sum.
     *
     * NOTE: Suppose B = 4 and array A contains 10 elements then
     * You can pick the first four elements or can pick the last four elements or can pick 1 from the front and 3 from the back etc. you need to return the maximum possible sum of elements you can pick.
     *
     * Problem Constraints
     * 1 <= N <= 105
     *
     * 1 <= B <= N
     *
     * -103 <= A[i] <= 103
     */


    /** Algo.. this is semi-inception, not complete.. good to remember this in daily life usecases
     *
     *
     * Way to do it is to add all numbers from 0 to position B
     * Now while doing sum, go reverse from position B, by removing element from B and adding a value from end
     * if this val > maxSum.. consider it as maxSum
     *
     */

    public int solve(ArrayList<Integer> A, int B) {
        int sum = 0;
        for (int i = 0; i < B ; i++) {
            sum += A.get(i);
        }

        int maxSum = sum;
        int end = A.size()-1;

        for (int start = B-1;  start >= 0; start--) {
            sum = sum + A.get(end) - A.get(start);
            maxSum = Math.max(maxSum, sum);
            end--;
        }

        return maxSum;

    }

    public static void main(String []args) {
        /*
        int []arr = new int[]{-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173,
                961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895,
                447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336,
                141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684,
                35, -810, 842, -712, -894, 40, -58, 264, -352, 446, 805, 890, -271, -630, 350, 6, 101, -607,
                548, 629, -377, -916, 954, -244, 840, -34, 376, 931, -692, -56, -561, -374, 323, 537, 538,
                -882, -918, -71, -459, -167, 115, -361, 658, -296, 930, 977, -694, 673, -614, 21, -255, -76, 72,
                -730, 829, -223, 573, 97, -488, 986, 290, 161, -364, -645, -233, 655, 574, -969, -948, 350, 150,
                -59, 724, 966, 430, 107, -809, -993, 337, 457, -713 };
        */

        int [] arr = new int[]{4, -1, 3, 4, -2, -3, 2, -10, 1};


        int B = 4;
        ArrayList<Integer> A= new ArrayList<>();
        for(int i : arr) {
            A.add(i);
        }
        System.out.println(new PickFromBothSides().solve(A, B));

    }
}
