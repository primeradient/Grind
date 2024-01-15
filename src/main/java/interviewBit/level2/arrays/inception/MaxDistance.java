package interviewBit.level2.arrays.inception;

import java.util.ArrayList;
import java.util.List;

public class MaxDistance {

    public int maximumGap(final List<Integer> A) {
        int maxDistance = Integer.MIN_VALUE;

        int [] maxRight = new int[A.size()];
        int [] minLeft = new int[A.size()];

        minLeft[0] = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            minLeft[i] = Math.min(A.get(i), minLeft[i-1]);
        }
        maxRight[A.size()-1] = A.get(A.size()-1);
        for (int i = A.size()-2; i>= 0; i--) {
            maxRight[i] = Math.max(A.get(i), maxRight[i+1]);
        }

        int i = 0;
        int j = 0;

        /** if minLeft[i] <= maxRight[j], our condition, get max(j-1), go fwd on right
         *   else go fwd on left
         */


        while  ( i < A.size() && j < A.size()) {
            if ( minLeft[i] <= maxRight[j]) {
                maxDistance = Math.max(maxDistance, j - i);
                j++;
            } else i++;
        }

        return maxDistance;
    }

    public static void main(String[] args)  {
        int arr[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
        List<Integer> A = new ArrayList<>();
        for ( int val : arr) {
            A.add(val);
        }
        int maxDiff = new MaxDistance().maximumGap(A);
        System.out.println(maxDiff);
    }
}
