package interviewBit.arrays;

import java.util.Arrays;

/**
 * Given a matrix, A of size M x N of 0s and 1s.
 * If an element is 0, set its entire row and column to 0.
 *
 */
public class SetMatrixZero {

    /* Algo

    Follow the steps to solve the problem:

    1. First, we will traverse the matrix and update the first row and first column as follows
        - we check for cell(i,j)
            if it is zero then we mark arr[i][0] equal to zero and arr[0][j] equal to zero.
    2. one special case to keep in mind is when i is 0,
         - we will mark matrix[0][0] with 0 but if j is 0, we will mark the C0 variable with 0 instead of marking matrix[0][0] again
           (because one cell can not represent for both row and column)
    3. Now we will traverse cells from (1,1) to (n-1,m-1) and update the matrix’s cell(i,j) according to the first row and first column.
    In the end, we will change the matrix’s first row and first column of the matrix as follows, we will change the row first and then the column.
    If arr[0][0] = 0, we will change all the elements from the cell (0,1) to (0, m-1), to 0.
    If C0 = 0, we will change all the elements from the cell (0,0) to (n-1, 0), to 0.


     */
    public static void setMatrixZeroes(int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;

        int C0 = 1;

        // Traverse the matrix and mark 1st row & 1st col as
        // follows:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {

                    matrix[i][0] = 0;     // mark arr[i][0] equal to zero and arr[0][j] equal to zero.

                    if (j == 0)
                        C0 = 0;
                    else
                        matrix[0][j] = 0;   // mark arr[i][0] equal to zero and arr[0][j] equal to zero.
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {

                    // Now we will traverse cells from (1,1) to (n-1,m-1) and update the matrix’s cell(i,j) according to the first row and first column.
                    if (matrix[i][0] == 0  || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // Finally mark the 1st row then 1st col:
        if (matrix[0][0] == 0) {   //if 1st row is 0, mark full row as 0
            Arrays.fill(matrix[0], 0);
        }

        if (C0 == 0) {    //if 1st col is 0, mark full col as 0
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // Driver Code
    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 } };

        // Function call
        setMatrixZeroes(matrix);

        // Print the resulting matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}
