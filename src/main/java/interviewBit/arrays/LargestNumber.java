package interviewBit.arrays;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

/*
        ************ ALGO ************
        1. Convert list of integers to String array
        2. Sort the string array. custom comparator
                (str2 + str1).compareTo(str1 + str2)
        3. Merge the strings in sequence
        *****************************
 */

    public String largestNumber(final List<Integer> a) {

        String[] arr = new String[a.size()];
        for (int i = 0; i < a.size(); i++) {
            arr[i] = String.valueOf(a.get(i));
        }


        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String a, String b){
                int val =  (b+a).compareTo(a+b);
                return val;
            }
        });


        StringBuilder sb = new StringBuilder();
        for(String s: arr){
            sb.append(s);
        }

        return new BigInteger(sb.toString()).toString();


    }

    public static void main(String [] args) {
        if ( "9648527226766636354854724412368319".equals(new LargestNumber().largestNumber(new ArrayList<>(Arrays.asList(9, 99, 999, 9999, 9998))))) {
            System.out.println("Matched..");
        } else {
            System.out.println("No Matched..");
        }
    }
}
