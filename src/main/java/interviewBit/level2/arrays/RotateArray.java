package interviewBit.level2.arrays;

import java.util.ArrayList;
import java.util.List;

public class RotateArray {
    /**
     *  Rotate an Array by B positions
     *  Time Complexity below is O(N) where N is size of array to be rotated
     */
    public List<Integer>  rotateArray(List<Integer>A, int B) {
        List<Integer> ret = new ArrayList<>();

        int start = B % A.size(); //Determine where you start rotating => RotateCount % Size

        for (int i = 0 ; i < A.size(); i++) {
            System.out.print(A.get(start) + " ");

            ret.add(A.get(start));
            start = (start + 1) >= A.size() ? 0: start+1;   //Incr start. if > N then set to 0
        }
        return ret;

    }



    public static void main(String args[]) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        for (int i = 1; i < 13; i++) {
            new RotateArray().rotateArray(A, i);
            System.out.println(" <= " + i );
        }


    }
}
