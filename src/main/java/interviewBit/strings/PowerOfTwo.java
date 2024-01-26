package interviewBit.strings;

import java.math.BigInteger;

public class PowerOfTwo {
    /*

    Fastest way is still by inspecting the bits. Assuming your number is x, in java you could do x & (x - 1) == 0 if true then it would be a power of 2

    Ref: https://stackoverflow.com/questions/42964882/test-if-a-big-integer-is-a-power-of-two

     */

    public int power(String A) {
        BigInteger x = new BigInteger(A);

        int isOne = x.compareTo(BigInteger.ONE);
        if ( isOne == 0 ) return 0;

        boolean result = x.and(x.subtract(BigInteger.ONE)).equals(BigInteger.ZERO)	 ;
        return ( result ) ?  1 : 0;
    }
}
