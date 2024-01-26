package interviewBit.arrays;

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
 * print any index pair(i, j) such that sum(arr[0..i]) = sum(arr[i+1..j]) = sum(arr[j+1..n-1]), otherwise print -1.
 */


public class ParitionInThreeEqualSum {
    /**
     *    Requirement is to divide that order is not disturbed, so sort or any other way to change sequence is not required.
     *
     *    We need to partition this into three sections which have equals sum
     *    By rule of MATHEMATICS, if sum of all cannot be divided by 3, we cannot split this into 3 sections
     *    So first check if we can divide it by 3
     *
     *    If yes, we only need to find 2 halfs to solve the problems ie. support sum/3 = S
     *
     *    S/3 + S/3 + S/3 = S
     *
     *    or  S/3 + 2*(S/3) = S
     *
     *    for find two halfs such that
     *       1st half has S/3 and 2nd half has 2*(S/3)
     *
     *    so the output will include
     */

    public void solve(int A, ArrayList<Integer> B) {
        int sum = 0;
        for (int i = 0; i < B.size(); i++) {
            sum = sum + B.get(i);
        }
        if ( sum % 3 != 0) {
            System.out.println("Not able to partition in three equals sums !!");
            return;
        }

        int splitSum = sum/3;

        int index1 = -1, index2 = -1;

        int currSum = 0;
        for (int i = 0; i < B.size(); i++) {
            currSum = currSum + B.get(i);

            if ( currSum == splitSum && index1 == -1) {
                index1 = i;
                currSum = 0;
            } else if ( currSum == splitSum && index1 != -1) {
                index2 = i;
                break;
            }
        }

        System.out.println("Indexes are (0 - " + index1 + "), (" + (index1+1) + " - " + index2 + " ), (" + (index2+1) + " - " + (B.size()-1) + " )");

    }

    public static void main(String [] args) {
        int [] arr = new int[]{  1, 2, 3, 0, 3 };
        ArrayList<Integer> B = new ArrayList<>();
        for (int i : arr) {
            B.add(i);
        }

        new ParitionInThreeEqualSum().solve(B.size(), B);
    }
}
