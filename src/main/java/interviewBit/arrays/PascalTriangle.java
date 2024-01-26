package interviewBit.arrays;

import java.util.ArrayList;

/*

Given a non-negative integer N, the task is to find the Nth row of Pascal’s Triangle.

Note: The row index starts from 0.

Pascal’s Triangle:
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1    i.e.  a[i][j] = a[i][j-1] + a[i-1][j-1]
*/


public class PascalTriangle {

    /*********** ALGO **************
        1. arr[N][0] = 1
        2. for i = 1 <= N
            arr[N][i] = (arr[N][i-1]  * (N - i + 1)) / i
     *******************************/
    public ArrayList<Integer> getRow(int N) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int prev = 1;
        result.add(prev);
        for(int i = 1; i <= N; i++)  {
            int curr = (prev * (N - i + 1)) / i;
            result.add(curr);
            prev = curr;
        }
        return result;
    }


}
