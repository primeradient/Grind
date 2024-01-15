package interviewBit.level2.arrays.inception;

import java.util.ArrayList;

/**
 * You are given a 1D integer array B containing A integers.
 *
 * Count the number of ways to split all the elements of the array into 3 contiguous parts so that the sum of elements in each part is the same.
 *
 * Such that : sum(B[1],..B[i]) = sum(B[i+1],...B[j]) = sum(B[j+1],...B[n])
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 105
 *
 * -109 <= B[i] <= 109
 *
 *
 *
 * Input Format
 * First argument is an integer A.
 *
 * Second argument is an 1D integer array B of size A.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the number of ways to split the array B into three parts with the same sum.
 */


public class CountWaysToParitionInThreeEqualSum {


    public int solve(int A, ArrayList<Integer> B) {
        int sum = 0;
        int [] suffixArray = new int[B.size()];

        for (int i = 0; i < B.size(); i++) {
            sum = sum + B.get(i);
            suffixArray[i] = 0;
        }
        if ( sum % 3 != 0) {
            return 0;
        }

        int splitSum = sum/3;
        int wayCount = 0;

        int runningSum = 0;
        for (int i = B.size()-1; i >= 0; i--) {
            runningSum = runningSum + B.get(i);
            if ( runningSum == splitSum ) {
                suffixArray[i] = 1;
            }
        }

        for (int i = B.size()-2; i>=0; i--) {
            suffixArray[i] = suffixArray[i] + suffixArray[i+1];
        }

        runningSum = 0;
        for (int i = 0; i < B.size()-2;i++) {
            runningSum = runningSum + B.get(i);
            if ( runningSum == splitSum) {
                wayCount = wayCount + suffixArray[i+2];
            }
        }


        return wayCount;
    }

    public static void main(String [] args) {
        int [] arr = new int[]{  0, 0, 0, 0, 0, 0, 0, 0, 0 };
        ArrayList<Integer> B = new ArrayList<>();
        for (int i : arr) {
            B.add(i);
        }

        System.out.println(new CountWaysToParitionInThreeEqualSum().solve(B.size(), B));
    }


}
