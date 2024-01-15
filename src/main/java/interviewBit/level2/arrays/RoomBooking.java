package interviewBit.level2.arrays;

import java.util.*;

public class RoomBooking {

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Map<Integer, Integer> occupancyCount = new HashMap<>();
        for (int i = 0; i < arrive.size(); i++) {
            int start = arrive.get(i);
            int end = depart.get(i);
            for (int j = start; j <= end; j++) {
                if ( !occupancyCount.containsKey(j)) {
                    occupancyCount.put(j,0);
                }
                occupancyCount.put(j, occupancyCount.get(j)+1);
                if ( occupancyCount.get(j) > K) return false;
            }
        }
        return true;
    }


    public static void main(String [] arg) {
        int [] a = new int[] { 1,2,3 };
        int [] b = new int[] { 2,3,4};
        int K = 1;

        ArrayList<Integer> A = new ArrayList<>();
        for ( int val : a) {
            A.add(val);
        }

        ArrayList<Integer> B = new ArrayList<>();
        for ( int val : b) {
            B.add(val);
        }


        System.out.println(new RoomBooking().hotel(A, B, K));
    }
}
