package interviewBit.level2.PandCinception;

/*
   Given a positive integer n and a string s consisting only of letters D or I,
   you have to find any permutation of first n positive integer that satisfy the given input string.

   D means the next number is smaller, while I means the next number is greater.

   Notes:  Length of given string s will always equal to n - 1

   Your solution should run in linear time and space.

   Example :
          n = 3
          s = ID

          Return: [1, 3, 2]
 */

import java.util.ArrayList;

public class FindPermutation {
    /* ALGO

     Understanding question here is primary. Its difficult without looking at hint.

     Try to keep an available range of element [l,r]. Initially, l=1 and r=n.

     You always need to select smallest or largest element from available range. Try to figure out how and when.

     So here, D means next number is smaller
              I means next number is greater

     Run through loop 1 to N
        Check value of s[i]
          if its D, pick the smallest number compared to prev. number
          if its I, pick the greater number compared to prev. number
          if s indexes are over, pick anything
     */

    public ArrayList<Integer> findPerm(final String A, int B) {

        int smallest = 1;
        int largest = B;
        ArrayList<Integer> op = new ArrayList<Integer>();
        for(int i=0;i<A.length();i++)  {
            if(A.charAt(i)=='D') {
                op.add(largest);
                largest = largest -1;
            } else {
                op.add(smallest);
                smallest = smallest+1;
            }
        }
        op.add(smallest);
        return op;
    }

    public static void main(String [] args) {
        ArrayList<Integer> res = new FindPermutation().findPerm("ID", 3);
        for ( int val : res) {
            System.out.print(" " + val);
        }
    }
}
