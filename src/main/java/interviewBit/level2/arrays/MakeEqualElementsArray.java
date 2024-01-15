package interviewBit.level2.arrays;

import java.util.ArrayList;

/*
Given an array of all positive integers and an element “x”.

You need to find out whether all array elements can be made equal or not by performing any of the 3 operations: add x to any element in array, subtract x from any element from array, do nothing.

 This operation can be performed only once on an element of array.



 */
public class MakeEqualElementsArray {

    /****************** Algo ************
     1. Find min, max
     2. If max-x != min+x,  return 0 //such an operation is not possible
     3. Now each number in array should match to sum = max-x
     4. For each number in array
        if its > min, check if arr[i] + x == sum
        if its < max, check if arr[i] - x == sum

     **************************************/

    public int solve(ArrayList<Integer> A, int B) {
        int min  = Integer.MAX_VALUE;
        int max   = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
        }
        if ( (min+B) != (max-B) ) return 0;
        if ( min == max ) return 0;
        int sum = min+B;
        for (int i = 0; i < A.size(); i++) {
            if ( A.get(i) == sum || A.get(i) == min || A.get(i) == max) continue;

            if ( A.get(i) > min) {
                int x = A.get(i) + B;
                if ( x != sum) {
                    return 0;
                }
            } else if ( A.get(i) < max) {
                int x = A.get(i) - B;
                if ( x != sum) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public static void main(String [] args ) {
        int [] arr = new int[]{ 3, 2, 1, 1, 2, 2, 1, 2, 3, 3, 1, 2, 3, 1, 2, 3, 2, 2, 1, 2, 3, 3, 2, 3, 3, 3, 1, 1, 1, 1, 2, 3, 3, 1, 1, 3, 3, 2, 3, 2, 3, 1, 1, 2, 1, 3, 1, 2, 1, 3, 3, 3, 1, 3, 3, 3, 3, 3, 1, 2, 2, 2, 2, 2, 2, 3, 2, 3, 3, 1, 2, 2, 2, 1, 1, 3, 2, 3, 2, 3, 1, 1, 3, 1, 3, 1, 1, 2, 1, 1, 1, 3, 1, 2, 1, 2, 2, 3, 3, 1, 3, 3, 2, 3, 1, 2, 1, 2, 2, 3, 2, 1, 2, 1, 1, 3, 2, 3, 2, 3, 1, 3, 1, 2, 2, 2, 2, 1, 2, 2, 1, 3, 3, 2, 1, 1, 3, 2, 1, 3, 1, 2, 2, 1, 2, 2, 2, 2, 3, 1, 1, 1, 1, 3, 2, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 3, 3, 2, 1, 3, 2, 3, 1, 2, 3, 2, 2, 3, 3, 2, 3, 1, 2, 1, 1, 1, 2, 1, 1, 3, 1, 3, 2, 3, 1, 2, 2, 3, 2, 2, 2, 3, 2, 3, 2, 3, 1, 2, 1, 3, 1, 1, 2, 2, 2, 3, 1, 1, 3, 1, 2, 3, 2, 3, 1, 3, 2, 1, 3, 1, 1, 3, 3, 1, 2, 3, 3, 1, 1, 2, 2, 1, 1, 3, 2, 1, 3, 2, 1, 2, 3, 1, 3, 1, 1, 1, 1, 1, 2, 2, 2, 1, 3, 3, 1, 3, 3, 1, 3, 3, 3, 1, 3, 2, 2, 2, 2, 1, 2, 2, 2, 1, 3, 2, 3, 2, 3, 2, 1, 1, 2, 3, 2, 1, 1, 2, 2, 1, 3, 3, 1, 1, 1, 3, 1, 3, 1, 3, 2, 2, 1, 3, 3, 3, 1, 1, 3, 1, 2, 3, 3, 2, 1, 1, 3, 2, 3, 1, 3, 3, 1, 1, 1, 3, 1, 1, 3, 3, 3, 2, 3, 2, 2, 3, 2, 1, 1, 1, 3, 3, 2, 2, 3, 3, 1, 1, 1, 1, 2, 2, 2, 3, 1, 3, 3, 2, 3, 1, 1, 2, 3, 1, 1, 2, 3, 2, 1, 1, 3, 3, 2, 1, 1, 2, 2, 3, 3, 1, 2, 1, 2, 3, 1, 3, 1, 2, 1, 1, 1, 2, 1, 2, 2, 2, 3, 2, 2, 2, 2, 1, 2, 2, 3, 3, 1, 3, 2, 2, 2, 2, 1, 3, 2, 1, 3, 3, 3, 2, 3, 1, 2, 1, 2, 2, 2, 1, 3, 3, 3, 2, 3, 3, 2, 3, 2, 2, 2, 2, 2, 1, 2, 1, 3, 1, 2, 1, 1, 1, 3, 2, 1, 3, 2, 3, 1, 2, 2, 2, 1, 3, 3, 3, 2, 2, 1 };


        ArrayList<Integer> B = new ArrayList<>();
        for (int i : arr) {
            B.add(i);
        }
        System.out.println(new MakeEqualElementsArray().solve(B,1));
    }
}
