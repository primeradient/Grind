package interviewBit.level2.arrays.inception;

import java.util.ArrayList;

/*

Given an integer array A of size N. You need to count the number of special elements in the given array.
A element is special if removal of that element make the array balanced.
Array will be balanced if sum of even index element equal to sum of odd index element.



Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109

Input Format
First and only argument is an integer array A of size N.

Output Format
Return an integer denoting the count of special elements.

Example Input
Input 1:

 A = [2, 1, 6, 4]
Input 2:

 A = [5, 5, 2, 5, 8]

Example Explanation
Explanation 1:

 After deleting 1 from array : {2,6,4}
    (2+4) = (6)
 Hence 1 is the only special element, so count is 1



*/
public class BalanceArray {
    /**

     Algo:
     Maintain PrefixSum and SuffixSum for odd and even index seperately.
     Let consider the following variable:
     leftOdd[i] : Denote the prefixSum of element on odd index till i-1.
     leftEven[i] : Denote the prefixSum of element on even index till i-1.
     rightOdd[i] : Denote the SuffixSum of element of odd index till i+1.
     rightEven[i] : Denote the SuffixSum of element of even index till i+1.

     Now, check if the ith element is the special or not.

     If leftOdd[i] + rightEven[i] == leftEven[i] + rightOdd[i], then ith element is special, so we increase the count.

     */

    //below solution does not work.
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int osum = 0;
        int esum = 0;
        int count = 0;
        for (int i = 0; i < n; i += 2) {
            esum += A.get(i);
        }

        for (int i = 1; i < n; i += 2) {
            osum += A.get(i);
        }

        for(int i=0;i<n;i++) {
            if(i%2==0) {
                esum-=A.get(i);
                if(esum==osum)count++;
            } else {
                osum-=A.get(i);
                if(osum==esum)
                    count++;
            }
        }
        return count;
    }
}
