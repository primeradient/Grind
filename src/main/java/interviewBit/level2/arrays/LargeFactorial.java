package interviewBit.level2.arrays;

import java.math.BigInteger;

public class LargeFactorial {

    public BigInteger factorial(BigInteger A) {
        if ( A.longValue() == 0L) return BigInteger.valueOf(1);
        else return A.multiply(factorial(A.subtract(BigInteger.valueOf(1))));
    }

    public String solve(int A) {
        BigInteger val = factorial(BigInteger.valueOf(A));
        return val.toString();
    }

    public static void main(String args[]) {
        System.out.println(new LargeFactorial().solve(100));
    }
}
