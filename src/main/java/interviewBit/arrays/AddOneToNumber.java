package interviewBit.arrays;
import java.math.BigInteger;
import java.util.ArrayList;
public class AddOneToNumber {

    /**
     * Given a non-negative number represented as an array of digits,
     * add 1 to the number ( increment the number represented by the digits ).
     *
     * The digits are stored such that the most significant digit is at the head of the list.
     *
     * Output Format
     * Return the array of digits after adding one.
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 106
     * 0 <= Ai <= 9
     */

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < A.size(); i++) {
            builder.append(A.get(i));
        }
        BigInteger val = new BigInteger(builder.toString());
        val = val.add(BigInteger.valueOf(1));
        String resultStr = val.toString();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < resultStr.length(); i++) {
            result.add(resultStr.charAt(i) - '0');
        }
        return result;
    }

    public static void main(String [] args) {
        int arr[] = new int[] {1, 9, 9, 9, 9, 9, 9 };
        ArrayList<Integer> A = new ArrayList<>();
        for ( int val : arr) {
            A.add(val);
        }
        new AddOneToNumber().plusOne(A);
    }


}
