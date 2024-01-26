package interviewBit.strings;

import java.math.BigInteger;


public class CompareVersionNumber {
    /**
     * If version1 > version2 return 1,
     * If version1 < version2 return -1,
     * otherwise return 0.
     */

    public int compareVersion(String version1, String version2) {

        if ( version1.equals(version2)) return 0;

        if ( !version1.contains(".") && !version2.contains(".")) {
            BigInteger b1 = new BigInteger(version1);
            BigInteger b2 = new BigInteger(version2);
            return b1.compareTo(b2);
        }

        String [] split1 = version1.split("\\.");
        String [] split2 = version2.split("\\.");

        int minIteration = Math.min(split1.length, split2.length);

        for (int i = 0; i < minIteration; i++) {
            BigInteger b1 = new BigInteger(split1[i]);
            BigInteger b2 = new BigInteger(split2[i]);
            int compare = b1.compareTo(b2);
            if ( compare != 0) {
                return compare;
            }
        }
        if ( split1.length == split2.length) return 0;
        if ( split1.length > split2.length ) {
            if ( new BigInteger(split1[minIteration]).longValue() == 0) {
                return 0;
            }
            return 1;
        } else {
            if ( new BigInteger(split2[minIteration]).longValue() == 0) {
                return 0;
            }
            return -1;
        }
    }

    public static void main(String [] args) {
        System.out.println(new CompareVersionNumber().compareVersion("1.0","1"));
    }


}
