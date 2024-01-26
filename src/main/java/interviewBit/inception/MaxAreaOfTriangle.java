package interviewBit.inception;

/*
Given a character matrix of size N x M in the form of a string array A of size N where A[i] denotes ith row.

Each character in the matrix consists any one of the following three characters {'r', 'g', 'b'} where 'r' denotes red color similarly 'g' denotes green color and 'b' denotes blue color.

You have to find the area of the largest triangle that has one side parallel to y-axis i.e vertical and the color of all three vertices are different.

NOTE:

If the area comes out to be a real number than return the ceil of that number.

Input Format
First and only argument is an string array A of size N denoting the 2D character matrix.



Output Format
Return a single integer denoting the area of the largest triangle that has one side parallel to y-axis i.e vertical and the color of all three vertices are different.

If the area comes out to be a real number than return the ceil of that number.


 */

import java.util.ArrayList;

public class MaxAreaOfTriangle {
    /* Algo

    We know area of a triangle = 1/2 * base *height, so we need to maximize the base and height of the triangle. Since one side is parallel to the y-axis, we can consider that side as the base of the triangle.

    Use this fact along with some pre-computation to find a solution to the problem.

    To maximize base, we can find the first and last occurrence of {r, g, b} for each column. So we have two sets of 3 values for each column. For base in any column, one vertex is from the first set and the second vertex from the second set such that they have different values.

    To maximize height, for any column as a base, the third vertex must be chosen such that the vertex should be farthest from the column, on the left or right side of the column having a value different from the other two vertices.
    Now for each column find the maximum area of the triangle.

    Time Complexity: O(NM)

     */

    public int solve(ArrayList<String> A) {


        int row = A.size();
        int col = A.get(0).length();

        int arr[][] = new int[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j< col; j++){

                arr[i][j] = getNumericValueForRGB(A.get(i).charAt(j));
            }
        }

        /*for(int i=0; i<row; i++){
            for(int j=0; j< col; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }*/

        int[] left = new int[3];
        int[] right = new int[3];
        int[][] top = new int[3][col];
        int[][] bottom = new int[3][col];

        for(int i=0; i<3;i++){
            left[i] = 100;
            right[i] = -1;
            for(int j=0; j<col; j++){
                top[i][j] = 100;
                bottom[i][j] = -1;
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j< col; j++){
                left[arr[i][j]] =  Math.min(left[arr[i][j]],j);
                right[arr[i][j]] = Math.max(left[arr[i][j]], j);
            }
        }

        for(int i=0; i<col; i++){
            for(int j=0; j< row; j++){
                top[arr[j][i]][i] =  Math.min(top[arr[j][i]][i],j);
                bottom[arr[j][i]][i] = Math.max(bottom[arr[j][i]][i], j);
            }
        }



        /*for(int i=0; i<3;i++){
            System.out.print(left[i]+ " ");
        }
        System.out.println();
        System.out.println();
        for(int i=0; i<3;i++){
            System.out.print(right[i]+ " ");
        }
        System.out.println();
        System.out.println();

        for(int i=0; i<3; i++){
            for(int j=0; j< col; j++){
                System.out.print(top[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();

        for(int i=0; i<3; i++){
            for(int j=0; j< col; j++){
                System.out.print(bottom[i][j]+ " ");
            }
            System.out.println();
        }*/

        return calculateMaxArea(left, right, top, bottom, col, row);

    }

    private int getNumericValueForRGB(char c){
        if(c == 'r'){
            return 0;
        }else if(c == 'g'){
            return 1;
        }else{
            return 2;
        }
    }

    private int calculateMaxArea(int[] left, int[] right, int[][] top, int[][] bottom, int col, int row){
        double ans = 0;

        for(int i =0; i< col; i++){
            for(int t=0; t<3;t++){
                for(int b=0; b<3; b++){
                    int z = 3-t-b;
                    if(t!=b && top[t][i]!=100 && bottom[b][i]!= -1 && left[z]!=100){
                        ans = Math.max(((1/2.0)*(bottom[b][i]-top[t][i]+1)*(i-left[z]+1)), ans);
                    }
                    if(t!=b && top[t][i]!=100 && bottom[b][i]!= -1 && right[z]!=-1){
                        ans = Math.max(((1/2.0)*(bottom[b][i]-top[t][i]+1)*(right[z]-i+1)), ans);
                    }
                }
            }
        }

        return (int)Math.ceil(ans);
    }
}
