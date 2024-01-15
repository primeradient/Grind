package interviewBit.level3.strings;

import java.math.BigInteger;

public class Atoi {

    public int atoi(final String A) {
        String str = "";
        boolean starts = false;
        int negIndex = -1;

        for (int i = 0; i < A.length(); i++) {
            if ( !starts && A.charAt(i) == '-') {
                negIndex = i;
                continue;
            } else if ( !starts && A.charAt(i) == '+') {
                continue;
            }

            if ( A.charAt(i) >= '0' && A.charAt(i) <= '9') {
                if ( !starts ) {
                    if ( negIndex != -1 && i - negIndex == 1) {
                        starts = true;
                    } else if ( negIndex == -1) {
                        starts = true;
                    } else return 0;
                }
                str = str + A.charAt(i);
            } else if ( starts && !(( A.charAt(i) >= '0' && A.charAt(i) <= '9'))) {
                break;
            } else return 0;
        }
        BigInteger val = new BigInteger(str);
        if (negIndex != -1) {
            val = val.multiply(new BigInteger("-1"));
        }
        if ( val.longValue() > Integer.MIN_VALUE && val.longValue() <  Integer.MAX_VALUE ) return val.intValue();
        return ( negIndex != -1 ) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }

    public static void main(String [] args) {
        String A = "-54332872018247709407 4 8X644 465 P18078";
        System.out.println(new Atoi().atoi(A));
    }
}
