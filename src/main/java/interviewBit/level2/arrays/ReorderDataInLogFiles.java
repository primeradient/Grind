package interviewBit.level2.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

/*
You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.

There are two types of logs:

Letter-logs: All words (except the identifier) consist of lowercase English letters.
Digit-logs: All words (except the identifier) consist of digits.

Reorder these logs so that:

The letter-logs come before all digit-logs.
The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
The digit-logs maintain their relative ordering.

Return the final order of the logs.


Problem Constraints
1 <= logs.length <= 1000
3 <= logs[i].length <= 1000
All the tokens of logs[i] are separated by a single space.
logs[i] is guaranteed to have an identifier and at least one word after the identifier.
 */


public class ReorderDataInLogFiles {


    public ArrayList<String> reorderLogs(ArrayList<String> A) {
        ArrayList<String> result = new ArrayList<>();
        TreeMap<String, String> stringLog = new TreeMap<>();
        ArrayList<String> digits = new ArrayList<>();
        for ( String line : A) {
            String log = line.substring(line.indexOf("-")+1);
            String [] split = log.split("-");
            boolean isDigit = true;
            for ( String token : split) {
                for (int i = 0; i < token.length(); i++) {
                    if ( token.charAt(i) < '0' || token.charAt(i) > '9') {
                        isDigit = false;
                        break;
                    }
                }
            }
            if ( isDigit ) {
                digits.add(line);
            } else {
                stringLog.put( log, line);
            }
        }

        for ( String str : stringLog.values()) {
            result.add(str);
        }
        result.addAll(digits);
        return result;
    }


    public static void main(String [] args) {
        String [] arr  = new String [] { "a1-9-2-3-1","g1-act-car","zo4-4-7","ab1-off-key-dog","a8-act-zoo" };
        ArrayList<String> A = new ArrayList<>();
        for ( String str : arr) {
            A.add(str);
        }
        ArrayList<String> result = new ReorderDataInLogFiles().reorderLogs(A);
        for ( String line : result) {
            System.out.println(line);
        }
    }




}
