package interviewBit.strings;
import java.util.ArrayList;

public class LongestCommonPrefix {

    public String longestCommonPrefix(ArrayList<String> A) {
        String prefix = "";
        int minLength = Integer.MAX_VALUE;
        for (int i = 0 ; i < A.size(); i++) {
            minLength = Math.min(minLength, A.get(i).length());
        }

        for (int i = 0; i < minLength; i++) {
            char ch = '-' ;
            boolean allSame = true;
            boolean started = false;
            for (String str : A) {
                if ( started == false ) {
                    ch = str.charAt(i);
                    started = true;
                }
                if ( str.charAt(i) != ch ) {
                    allSame = false;
                    break;
                }
            }
            if ( allSame ) {
                prefix = prefix + ch;
            } else break;
        }


        return prefix;
    }

    public static void main(String [] args) {
        ArrayList<String> A = new ArrayList<>();
        String [] arr = new String [] { "aaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" };
        for ( String str : arr) {
            A.add(str);
        }

        System.out.println(new LongestCommonPrefix().longestCommonPrefix(A));
    }
}
