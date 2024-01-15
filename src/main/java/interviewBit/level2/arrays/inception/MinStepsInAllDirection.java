package interviewBit.level2.arrays.inception;

import java.util.ArrayList;

/*
  You are in an infinite 2D grid where you can move in any of the 8 directions

 (x,y) to
    (x-1, y-1),
    (x-1, y)  ,
    (x-1, y+1),
    (x  , y-1),
    (x  , y+1),
    (x+1, y-1),
    (x+1, y)  ,
    (x+1, y+1)

You are given a sequence of points and the order in which you need to cover the points..
Give the minimum number of steps in which you can achieve it. You start from the first point.

Problem Constraints
   1 <= |A| <= 106
   -2 * 103 <= Ai, Bi <= 2 * 103
   |A| == |B|


Input Format
Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.

Output Format
Return an Integer, i.e minimum number of steps.

Example Input
Input 1:

 A = [0, 1, 1]
 B = [0, 1, 2]


Example Output
Output 1:

 2


Example Explanation
Explanation 1:

 Given three points are: (0, 0), (1, 1) and (1, 2).
 It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 */

public class MinStepsInAllDirection {

    /** the solution is pure formula. I also wrote a recursive version for this which worked but not on all inputs. **/

    /**
     * Ref: https://stackoverflow.com/questions/15179481/how-to-calculate-distance-between-2-points-in-a-2d-matrix
     *
     * Horizontally/Vertically
     * ---------------------------------------
     * In this case, you can go up/down or left/right. As you have to travel X axis and Y axis independently, your ans is:
     * jumpDistance = abs(x2 - x1) + abs(y2 - y1);
     *
     *
     * Horizontally/Vertically and also Diagonally
     * ---------------------------------------------
     * In this case, you can go up/down or left/right and diagonally as well.
     * How it differs from Case 1 is that now you have the ability to change your X axis and Y axis together at the cost of only one jump . Your answer now is:
     * jumpDistance = Max(abs(x2 - x1),abs(y2 - y1));
     */

    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int steps = 0;
        for(int i = 1;i<A.size();i++){
            steps+= Math.max(Math.abs(A.get(i)-A.get(i-1)),Math.abs(B.get(i)-B.get(i-1)));  //remember it
        }
        return steps;
    }


    public static void main(String []args) {
        /**
         * A : [ -10, -9, 12, 4, -11, 6, -9, -14, 7 ]
         * B : [ 5, -1, -11, -10, -6, -8, 0, -2, 14  ]
         *
         * The expected return value:
         * 108
         */
        int [] a = new int[]{-10, -9, 12, 4, -11, 6, -9, -14, 7};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i : a) {
            A.add(i);
        }

        int [] b = new int[]{5, -1, -11, -10, -6, -8, 0, -2, 14 };
        ArrayList<Integer> B = new ArrayList<>();
        for (int i : b) {
            B.add(i);
        }

        System.out.println(new MinStepsInAllDirection().coverPoints(A, B));
     }
}
