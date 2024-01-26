package interviewBit.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an array of integers A, sort the array into a wave-like array and return it.
 * In other words, arrange the elements into a sequence such that
 *
 * a1 >= a2 <= a3 >= a4 <= a5.....
 * NOTE: If multiple answers are possible, return the lexicographically smallest one.
 *
 *
 *
 * Problem Constraints
 * 1 <= len(A) <= 106
 *
 * 1 <= A[i] <= 106
 *
 *
 *
 * Input Format
 * The first argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an array arranged in the sequence as described.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4]
 *
 * Example Output
 * Output 1:
 *
 * [2, 1, 4, 3]

 * Example Explanation
 * Explanation 1:
 *
 * One possible answer : [2, 1, 4, 3]
 * Another possible answer : [4, 1, 3, 2]
 * First answer is lexicographically smallest. So, return [2, 1, 4, 3].
 */
public class WaveArray {

    //This is basically swapping every two elements (after sort is done) to get the wave

    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        for (int i = 0; i < A.size(); ) {
            if ( i+1 >= A.size()) break;
            int tmp = A.get(i+1);
            A.set(i+1, A.get(i));
            A.set(i, tmp);
            i=i+2;
        }
        return A;
    }

    public static void main(String [] arg) {
        int [] arr = new int[] { 6, 17, 15, 13 };
        ArrayList<Integer> A = new ArrayList<>();
        for ( int val : arr) {
            A.add(val);
        }

        for (int val : new WaveArray().wave(A)) {
            System.out.print(" " + val);
        }
    }
}
