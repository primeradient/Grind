package interviewBit.level2.arrays.inception;

import java.util.ArrayList;
/*
Given a positive integer n, print the matrix filled with rectangle pattern as shown below:
a a a a a
a b b b a
a b c b a
a b b b a
a a a a a
where a = n, b = n – 1,c = n – 2 and so on.

Examples:

Input : n = 4
Output :
4 4 4 4 4 4 4
4 3 3 3 3 3 4
4 3 2 2 2 3 4
4 3 2 1 2 3 4
4 3 2 2 2 3 4
4 3 3 3 3 3 4
4 4 4 4 4 4 4

Input : n = 3
Output :
3 3 3 3 3
3 2 2 2 3
3 2 1 2 3
3 2 2 2 3
3 3 3 3 3

 */

public class PrettyPrint {
    /**

     For the given n, the number of rows or columns to be printed will be 2*n – 1. We will print the matrix in two parts. We will first print upper half from rows from 0 to floor((2*n – 1)/2) and then second half from floor((2*n – 1)/2) + 1 to 2*n – 2.

     Now for each row, we will print it in three parts. First part is decreasing sequence which will start from n and decrease by 1 in each iteration. The number of iteration will be equal to row number, the second part is a constant sequence where constant is n – i and it will be print 2*n – 1 – 2 * row number, and the third part is increasing sequence which is nothing but opposite of the first sequence.


     For lower half, observe, it is a mirror image of upper half (excluding middle row). So, simply run a loop of the upper half from (2*n – 1)/2 to 0.


     */
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {

        int n = 2*A-1;
        int lim = n, tmp = 0;
        int v [][] = new int[n][n];

        while(A > 0) {
            for(int i=tmp; i<lim; i++) {
                for(int j=tmp; j<lim; j++) {
                    v[i][j] = A;
                }
            }

            A--;
            lim--;
            tmp++;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < v.length; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < v.length; j++) {
                row.add(v[i][j]);
            }
            result.add(row);
        }
        return result;

    }

    public static void main(String [] args) {
        ArrayList<ArrayList<Integer>> arr = new PrettyPrint().prettyPrint(4);
        for ( ArrayList<Integer> row : arr) {
            for ( int val : row) {
                System.out.print(" " + val);
            }
        }
        System.out.println("\n");
    }
}
