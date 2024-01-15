package interviewBit.level2.arrays.inception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateMatrix {
    /**
     Algo
     ---------------
     Transform each row of source matrix into required column of final matrix.

     first row of source ------> last column of destination
     second row of source ------> last but-one column of destination
     so ... on
     last row of source ------> first column of destination

     result[j][matrix.size() - i - 1] = matrix[i][j];




     */

    public void rotate(List<List<Integer>> A) {
        int n;

        if (A == null)
            return;

        n = A.size();

        if (n == 0)
            return;

        int layers = n;
        int row1, col1, row2, col2;
        int num;
        int temp;
        int first, last;

        for (int layer = 0; layer < layers / 2; layer++) {

            first = layer;
            last = n - layer - 1;

            for (int i = first; i < last; i++) {

                int offset = i - layer;

                int top = A.get(first).get(i);

                A.get(first).set(i, A.get(last - offset).get(first));

                A.get(last - offset).set(first, A.get(last).get(last - offset));

                A.get(last).set(last - offset, A.get(i).get(last));

                A.get(i).set(last, top);
            }

        }

    }

    public static void main(String [] args) {
        List<List<Integer>> A = new ArrayList<>();
        A.add(Arrays.asList( new Integer [] {1,2}));
        A.add(Arrays.asList( new Integer [] {3,4}));

        new RotateMatrix().rotate(A);
        for(int i = 0; i < A.size();i++) {
            List<Integer> B = A.get(i);
            for (int j = 0;   j < B.size(); j++) {
                System.out.print(" " + B.get(j));
            }
            System.out.println("\n");
        }

    }
}
