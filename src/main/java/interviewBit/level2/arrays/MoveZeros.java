package interviewBit.level2.arrays;

import java.util.ArrayList;

/*

Problem Description



Given an integer array A, move all 0's to the end of it while maintaining the relative order of the non-zero elements.


Note that you must do this in-place without making a copy of the array.



Problem Constraints
1 <= |A| <= 105


Input Format
First argument is array of integers A.


Output Format
Return an array of integers which satisfies above property.


 */
public class MoveZeros {

    /**************** Algo **************
    1. Create a new list and all nonZero's to it
    2. While doing, count number of 0s found
    3. append 0s equal to number of 0s found to list and return
    ************************************/

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> nonZeroList = new ArrayList<>();
        int zeroToAdd = 0;
        for (int i = 0; i < A.size(); i++) {
            if ( A.get(i) != 0) {
                nonZeroList.add(A.get(i));
            } else zeroToAdd++;
        }

        for (int i = 0; i < zeroToAdd; i++) {
            nonZeroList.add(0);
        }
        return nonZeroList;
    }

    public static void main(String [] args ) {
        int [] arr = new int[]{ 0, 1, 0, 3, 12 };


        ArrayList<Integer> B = new ArrayList<>();
        for (int i : arr) {
            B.add(i);
        }
        ArrayList<Integer> result = new MoveZeros().solve(B);
        for ( int val : result) {
            System.out.print(" " + val);
        }
    }

}
