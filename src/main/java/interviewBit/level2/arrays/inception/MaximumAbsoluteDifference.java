package interviewBit.level2.arrays.inception;

import java.util.ArrayList;

/**

 You are given an array of N integers, A1, A2 ,..., AN.

 Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.

 where f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.


 Problem Constraints
 1 <= |A| <= 105
 -109 <= Ai <= 109


 */
public class MaximumAbsoluteDifference {
    /** Algo

     f(i, j) = |A[i] - A[j]| + |i - j| can be written in 4 ways
     (Since we are looking at max value, we don’t even care if the value becomes negative as long as we are also covering the max value in some way).

     (A[i] + i) - (A[j] + j)
     -(A[i] - i) + (A[j] - j)
     (A[i] - i) - (A[j] - j)
     (-A[i] - i) + (A[j] + j) = -(A[i] + i) + (A[j] + j)
     Note that case 1 and 4 are equivalent and so are case 2 and 3.

     We can construct two arrays with values: A[i] + i and A[i] - i.

     Then, for above 2 cases, we find the maximum value possible.
     For that, we just have to store minimum and maximum values of expressions A[i] + i and A[i] - i for all i.


     */

    public int maxArr(ArrayList<Integer> A) {

        int maxSums=A.get(0);
        int minSums=A.get(0);
        for(int i=0;i<A.size();i++)
        {
            maxSums=Math.max(maxSums,A.get(i)+i);
            minSums=Math.min(minSums,A.get(i)+i);
        }
        int sumsRes=maxSums-minSums;

        int maxDif=A.get(0);
        int minDif=A.get(0);
        for(int i=0;i<A.size();i++)
        {
            maxDif=Math.max(maxDif,A.get(i)-i);
            minDif=Math.min(minDif,A.get(i)-i);
        }
        int difsRes=maxDif-minDif;
        return Math.max(difsRes,sumsRes);
    }
}
