package interviewBit.level2.arrays.inception;

import java.util.ArrayList;
import java.util.Collections;

public class SetIntersection {
    /*
    An integer interval [X, Y] (for integers X < Y) is a set of all consecutive integers from X to Y, including X and Y.

    You are given a 2D array A with dimensions N x 2, where each row denotes an interval.

    Find the minimum size of a set S such that for every integer interval Z in A, the intersection of S with Z has a size of at least two.

    ex:
    A = [[1, 3], [1, 4], [2, 5], [3, 5]]

   Consider the set S = {2, 3, 4}.  For each interval, there are at least 2 elements from S in the interval.
   Also, there isn't a smaller size set that fulfills the above condition.
   Thus, we output the size of this set, which is 3.


   A = [[1, 2], [2, 3], [2, 4], [4, 5]]
   An example of a minimum sized set is {1, 2, 3, 4, 5}, so solution is 5


     */

    /*
    Algo:

    Firstly, we need to sort the intervals by the right border first (ascending), and then the left border(ascending).
    Then, we add the end and end - 1 of the first interval.
    Then, we look at the boundaries of the current interval.
    We need to either add zero, one, or at most two points to make the current interval fit the problem condition.


     */
    public int setIntersection(ArrayList<ArrayList<Integer>> A) {

        int ans = 0;
        int max = -1;
        int secondMax = -1;

        Collections.sort(A, (a,b) -> a.get(1) == b.get(1) ? b.get(0) - a.get(0) : a.get(1) - b.get(1));

        for(ArrayList<Integer> interval : A) {

            int a = interval.get(0);
            int b = interval.get(1);

            if(max >= a && secondMax >= a) {
                continue;
            }

            if(max >= a) {
                secondMax = max;
                max = b;
                ans+=1;
            } else {
                secondMax = b - 1;
                max = b;
                ans+=2;
            }
        }

        return ans;
    }
}
