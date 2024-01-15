package interviewBit.level2.PandCinception;

/*

Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.

If such an arrangement is not possible, it must be rearranged in the lowest possible order i.e., sorted in ascending order.

Note:
The replacement must be in-place, do not allocate extra memory.


Problem Constraints
1 <= N <= 5e5
1 <= A[i] <= 1e9


Example Input
Input 1:
    A = [1, 2, 3]    =>   [1, 3, 2]
Input 2:
    A = [3, 2, 1]   =>    [1, 2, 3]
Input 3:
    A = [1, 1, 5]  =>    [1, 5, 1]
Input 4:
    A = [20, 50, 113]   =>   [20, 113, 50]




 */

import java.util.ArrayList;

public class NextPermutation {

    /*
       Algorithm :  https://www.interviewbit.com/blog/next-permutation-problem/

        Traverse the array from end and find the first index, idx such that A[i] < A[i + 1].
        Again traverse the array from the end and find the first index, ind such that A[i] > A[idx].
        Swap A[idx] and A[ind].
        Reverse the array from idx + 1 till N.
        The base case would be, if the array is in decreasing order, no next permutation will be found, hence return the array in sorted order.

     */
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> nums) {
        int idx = -1;
        for(int i=nums.size()-2; i>=0; i--) {
            if(nums.get(i) < nums.get(i+1)) {
                idx = i;
                break;
            }
        }
        if(idx == -1) {
            for(int i=0; i<nums.size()/2; i++) {
                int temp = nums.get(i);
                nums.set(i, nums.get(nums.size() - i -1));
                nums.set(nums.size() - i -1, temp);
            }
        }
        else {
            for(int i=nums.size()-1; i>=0; i--) {
                if(nums.get(i) > nums.get(idx)) {
                    int temp = nums.get(i);
                    nums.set(i, nums.get(idx));
                    nums.set(idx, temp);
                    break;
                }
            }
            for(int i=0; i<(nums.size() - idx - 1)/2; i++) {
                int temp = nums.get(idx + 1 + i);
                nums.set(idx + 1 + i, nums.get(nums.size() - i -1));
                nums.set(nums.size() - i -1, temp);
            }
        }
        return nums;
    }
}
