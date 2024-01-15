package interviewBit.level2.arrays;

import java.util.ArrayList;

public class SegregateZeroAnd1s {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> nonZeroList = new ArrayList<>();
        int zeroToAdd = 0;
        for (int i = 0; i < A.size(); i++) {
            if ( A.get(i) != 1) {
                nonZeroList.add(0);
            } else zeroToAdd++;
        }

        for (int i = 0; i < zeroToAdd; i++) {
            nonZeroList.add(1);
        }
        return nonZeroList;
    }

    public static void main(String [] args ) {
        int [] arr = new int[]{ 0, 1, 0, 1, 1 };


        ArrayList<Integer> B = new ArrayList<>();
        for (int i : arr) {
            B.add(i);
        }
        ArrayList<Integer> result = new SegregateZeroAnd1s().solve(B);
        for ( int val : result) {
            System.out.print(" " + val);
        }
    }

}
