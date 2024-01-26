package interviewBit.inception;

import java.util.Arrays;
import java.util.List;
public class MaximumGapSuccessiveElements {
    /*

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
Return 0 if the array contains less than 2 elements.
You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.
Try to solve it in linear time/space



Problem Constraints
1 <= |A| <= 106
1 <= Ai <= 109


Input Format
The first argument is an integer array A.


Output Format
Return an integer representing maximum difference between the successive elements in array A.


Example Input
A = [1, 10, 5]


Example Output
5


*/
    public int maximumGap(final List<Integer> A) {

        if (A == null || A.size() < 2)
            return 0;

        int max = A.get(0);
        int min = A.get(0);
        int n = A.size();

        for (int i = 0; i < n; i++) {
            max = Math.max(max, A.get(i));
            min = Math.min(min, A.get(i));
        }

        int buckets = n - 1;
        int gap = (max - min - 1) / (n - 1) + 1;
        int minArray[] = new int[buckets];
        int maxArray[] = new int[buckets];
        int bucket;

        Arrays.fill(minArray, Integer.MAX_VALUE);
        Arrays.fill(maxArray, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            int num = A.get(i);

            if (num == max || num == min)
                continue;

            bucket = (num - min) / gap;

            minArray[bucket] = Math.min(minArray[bucket], num);
            maxArray[bucket] = Math.max(maxArray[bucket], num);
        }

        int res = 0;
        int maxVal = max;

        for (int i = 0; i < buckets; i++) {
            max = minArray[i];

            if (max != Integer.MAX_VALUE)
                res = Math.max(res, max - min);

            if (maxArray[i] != Integer.MIN_VALUE) {
                min = maxArray[i];
            }
        }

        res = Math.max(res, maxVal - min);

        return res;

    }


}
