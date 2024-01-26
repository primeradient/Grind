package interviewBit.inception;

/*
    Given a 2D integer matrix A of size N x N find a B x B submatrix where B<= N and B>= 1,
    such that sum of all the elements in submatrix is maximum.

    Input Format : First arguement is an 2D integer matrix A.
    Second argument is an integer B.

    Output Format: Return a single integer denoting the maximum sum of submatrix of size B x B
*/

import java.util.ArrayList;

public class MaximumSumSquareSubMatrix {

        /*

        Input 1:

     A = [
        [1, 1, 1, 1, 1]
        [2, 2, 2, 2, 2]
        [3, 8, 6, 7, 3]
        [4, 4, 4, 4, 4]
        [5, 5, 5, 5, 5]
     ]

     B = 3

    Maximum sum 3 x 3 matrix is
    8 6 7
    4 4 4
    5 5 5
    Sum = 48


    The idea is to preprocess the given square matrix.
    In the preprocessing step, calculate the sum of all vertical strips of size B x 1 in a temporary square matrix stripSum[][].
    Once we have the sum of all vertical strips, we can calculate the sum of the first sub-square in a row as

    the sum of the first B strips in that row, and for the remaining sub-squares,

    we can calculate the sum in O(1) time by removing the leftmost strip of the previous subsquare and adding

    the rightmost strip of the new square.

    Time complexity of this solution is O(N2).

         */


    private int res = Integer.MIN_VALUE;
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int startB = 0;
        int endB = B-1;
        int[] sums = new int[A.size()];
        for(int i = 0;i<A.size();++i){
            int sum = 0;
            for(int j = startB; j<=endB; ++j) sum += A.get(i).get(j);
            sums[i] = sum;
        }
        while(endB<A.size()){
            calculateMax(sums, B);
            if(endB!=A.size()-1)
                for(int i = 0;i<A.size();++i){
                    sums[i] -= A.get(i).get(startB);
                    sums[i]+=A.get(i).get(endB+1);
                }
            startB++;
            endB++;
        }
        calculateMax(sums, B);
        return this.res;

    }

    private void calculateMax(int[] sums, int B){
        int possible = 0;
        for(int i = 0;i<B;++i){
            possible += sums[i];
        }
        int i = 0;
        while(i<sums.length-B){
            this.res = Math.max(res, possible);
            possible-=sums[i];
            possible+=sums[i+B];
            i++;
        }
        this.res = Math.max(res, possible);
    }
}

