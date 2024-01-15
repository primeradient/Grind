package interviewBit.level2.map;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class NumberOccurance {
    /**
     You are given an integer array A.

     You have to find the number of occurences of each number.

     Return an array containing only the occurences with the smallest value's occurence first.

     For example, A = [4, 3, 3], you have to return an array [2, 1], where 2 is the number of occurences for element 3,
     and 1 is the number of occurences for element 4. But, 2 comes first because 3 is smaller than 4.
     **/

    public ArrayList<Integer> findOccurences(ArrayList<Integer> A) {
        Map<Integer, Integer> map =  new TreeMap<>();
        for (int val : A) {
            if ( map.get(val) == null) {
                map.put(val,0);
            }
            map.put(val,map.get(val)+1);
        }

        ArrayList<Integer> ret = new ArrayList<Integer>();
        for ( int occurance : map.values()) {
            ret.add(occurance);
            System.out.print(occurance + " ");
        }
        return ret;


    }


    public static void main(String [] args) {
        int [] A =new int[]{4, 3, 3};
        ArrayList<Integer> input = new ArrayList<>();
        for (int val : A) {
            input.add(val);
        }
        new NumberOccurance().findOccurences(input);
    }
}
