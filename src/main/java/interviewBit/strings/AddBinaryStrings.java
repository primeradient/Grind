package interviewBit.strings;

public class AddBinaryStrings {
    public String addBinary(String A, String B) {

        String result = "";
        String small  = (A.length() < B.length()) ? A : B;
        String large =  (A.length() >= B.length()) ? A : B;

        int minLength = small.length();
        int largeIndex = large.length()-1;

        int carry = 0;
        for (int i = small.length()-1; i >= 0; i--) {
            int a = ( small.charAt(i) == '0' ) ? 0 : 1;
            int b = ( large.charAt(largeIndex) == '0' ) ? 0 : 1;
            int c = a + b;
            if ( c == 2 && carry == 0 ) {
                c = 0;
                carry = 1;
            } else if ( c == 2 && carry == 1) {
                c = 1;
                carry = 1;
            } else {
                c = c + carry;
                if ( c == 2 ) {
                    c = 0;
                    carry = 1;
                } else if ( c == 1) {
                    c = 1;
                    carry = 0;
                } else {
                    carry = 0;
                }
            }
            result = c + result;
            largeIndex--;
        }

        for (int i = largeIndex; i >=0; i--) {
            int a = ( large.charAt(i) == '0' ) ? 0 : 1;
            int c = a + carry;
            carry = 0;
            if ( c == 2 && carry == 0 ) {
                c = 0;
                carry = 1;
            } else if ( c == 2 && carry == 1) {
                c = 1;
                carry = 1;
            } else {
                c = c + carry;
                if ( c == 2 ) {
                    c = 0;
                    carry = 1;
                } else if ( c == 1) {
                    c = 1;
                    carry = 0;
                } else {
                    carry = 0;
                }
            }
            result = c + result;
        }
        if ( carry == 1) {
            result = carry + result;
        }

        return result;
    }

    public static void main(String [] args) {
        System.out.println(new AddBinaryStrings().addBinary("110","10"));
    }
}
