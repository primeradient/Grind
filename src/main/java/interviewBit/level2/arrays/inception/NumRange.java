package interviewBit.level2.arrays.inception;

import java.util.ArrayList;

public class NumRange {

    public int numRange(ArrayList<Integer> A, int B, int C) {

        int count = 0;
        if(A.isEmpty()) {
            return count;
        }
        for(int i=0; i< A.size(); i++){
            int sum =0;
            for(int j = i ; j < A.size(); j++) {
                sum = sum + A.get(j);
                if(sum >= B && sum <=C){
                    count++;
                }
                if(sum > C) {
                    break;
                }
            }
        }
        return count;


    }

    public static void main(String [] args) {
        int [] arr = new int[]{ 76, 22, 81, 77, 95, 23, 27, 35, 24, 38, 15, 90, 19, 46, 53, 6, 77, 96, 100, 85, 43, 16, 73, 18, 7, 66 };
        ArrayList<Integer> A = new ArrayList<>();
        for ( int val : arr ) {
            A.add(val);
        }

        int B = 98;
        int C = 290;

        System.out.println(new NumRange().numRange(A, B, C));
    }
}
