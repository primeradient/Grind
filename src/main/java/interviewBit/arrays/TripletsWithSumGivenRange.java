package interviewBit.arrays;

import interviewBit.Util;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an array of real numbers greater than zero in form of strings. Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2. Return 1 for true or 0 for false.
 * O(n) solution is expected.
 * Note: You can assume the numbers in strings don't overflow the primitive data type and there are no leading zeroes in numbers. Extra memory usage is allowed.
 *
 *
 * Input Format
 * The first argument is an array of strings A.
 *
 *
 * Output Format
 * Return an integer, 1 for true or 0 for false.
 *
 */


public class TripletsWithSumGivenRange {
    double max = 2;
    double min = 1;

    public int solve(ArrayList<String> strA) {
        ArrayList<Double> A = new ArrayList<>();
        for ( String str : strA) {
            A.add(Double.parseDouble(str));
        }
        Collections.sort(A);

        int j, k;
        for (int i = 0; i < A.size()-2; i++) {

            // Initialize other two elements as corner elements of subarray
            j = i + 1;
            k = A.size() - 1;

            while (j != k)  {
                double sum = A.get(i) + A.get(j) + A.get(k);

                // If sum of current triplet is greater, then to reduce it i.e. decrease k.
                if (sum > max) {
                    k--;
                } else if  (sum < min) {
                    // If sum is less than or equal to given value, then add possible triplets (k-j) to result.
                    j++;
                } else return 1;
            }
        }

        return 0;
    }

    public static void main(String []args) {
        String [] arr = new String[]{"0.6", "0.7", "0.8", "1.2", "0.4"};
        System.out.println("Solution: " + new TripletsWithSumGivenRange().solve(Util.getList(arr)));
    }
}
