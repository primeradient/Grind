package interviewBit;

import java.util.ArrayList;

public class Util {

    public static ArrayList<String> getList(String []arr) {
        ArrayList<String> list = new ArrayList<>();
        for ( String str : arr) {
            list.add(str);
        }
        return list;
    }

    public static ArrayList<Integer> getList(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for ( int val : arr) {
            list.add(val);
        }
        return list;
    }
}
