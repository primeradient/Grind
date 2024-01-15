package interviewBit.level2.arrays.inception;

import java.util.Arrays;
import java.util.List;

public class PerfectPeakOfArray {

    public int perfectPeak(List<Integer> A) {
        if ( A.size() == 0) return 0;
        if ( A.size() == 1) return A.get(0);

        int maxRight [] = new int[A.size()];
        maxRight[0] = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            maxRight[i] = Math.max(maxRight[i-1],A.get(i));
        }

        int minLeft [] = new int[A.size()];
        minLeft[A.size()-1] = A.get(A.size()-1);
        for (int i = A.size()-2; i >= 0; i--) {
            minLeft[i] = Math.min(minLeft[i+1], A.get(i));
        }

        for(int i=1;i<A.size()-1;i++) {
            if( A.get(i)>maxRight[i-1] && A.get(i)<minLeft[i+1] )
                return 1;
        }

        return 0;
    }


    public static void main(String [] args) {
        Integer [] arr = new Integer[]{5, 1, 4, 3, 6, 8, 10, 7, 9 };
        System.out.println(new PerfectPeakOfArray().perfectPeak(Arrays.asList(arr)));
    }
}
