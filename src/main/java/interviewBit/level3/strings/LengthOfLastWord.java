package interviewBit.level3.strings;
/*

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.



Problem Constraints
1 <= |A| <= 106


Input Format
The first argument is a string A


Output Format
Return an integer denoting the length of the last word in the string.

 */
public class LengthOfLastWord {
    /** Algo: Start from End trying to capture last word **/
    StringBuilder builder;

    public int lengthOfLastWord(final String A) {

        int wordStart = 0;
        int wordEnd = -1;
        boolean started = false;

        if ( A.length() == 0 ) return 0;

        for (int i = A.length()-1; i >= 0; i--) {
            if (started && A.charAt(i) != ' ') {
                wordStart = i;
            } else if (started && A.charAt(i) == ' ') {
                break;
            } else if (!started && A.charAt(i) != ' ') {
                started = true;
                wordStart = i;
                wordEnd = i;
            }
        }
        return (wordEnd - wordStart) + 1;

    }

    public static void main(String [] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Lebz Q"));
    }
}
