package interviewBit.strings;

import java.util.ArrayList;
import java.util.List;

public class CountAndSay {
    public String countAndSay(int A) {
        String str = A + "";
        List<String> arr = new ArrayList<String>();

        String word = str.charAt(0) + "";
        for (int i = 1; i < str.length(); i++) {
            if ( str.charAt(i) == str.charAt(i-1)) {
                word = word + word;
            } else {
                arr.add(word);
                word = str.charAt(i) + "";
            }
        }
        arr.add(word);
        for ( String tmp : arr) {

        }
        return "";
    }

    public static void main( String [] args) {
        System.out.println(new CountAndSay().countAndSay(0));
    }
}
