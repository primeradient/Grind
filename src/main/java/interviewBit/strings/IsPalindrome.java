package interviewBit.strings;

public class IsPalindrome {
    private boolean isAlpha(char ch) {
        if ( ( ch >= '0' && ch <= '9') ||
                ( ch >= 'a' && ch <= 'z') ||
                ( ch >= 'A' && ch <= 'Z') ) {
            return true;
        }
        return false;
    }

    public boolean isNum(char ch) {
        return ( ch >= '0' && ch <= '9');
    }


    public int isPalindrome(String A) {
        int start = 0;
        int end = A.length()-1;
        while ( start < end) {
            while ( start < end && !isAlpha(A.charAt(start))) {
                start++;
            }
            while ( start < end && !isAlpha(A.charAt(end))) {
                end--;
            }

            if ( isNum(A.charAt(start)) && A.charAt(end) != A.charAt(start)) {
                return 0;
            }


            String a = (A.charAt(start) + "");
            String b = (A.charAt(end) + "");
            if (! a.equalsIgnoreCase(b)) return 0;

            start++;
            end--;
        }
        return 1;
    }

    public static void main(String [] args) {
        System.out.println(new IsPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
