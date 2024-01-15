package interviewBit.level3.strings;
/*

Problem Description: You are given a string A of size N.  Return the string A after reversing the string word by word.

NOTE:
A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.

Problem Constraints
1 <= N <= 3 * 105

Input Format
The only argument given is string A.

Output Format
Return the string A after reversing the string word by word.



Example Input
Input 1:
    A = "the sky is blue"

Output 1:
    "blue is sky the"
 */

public class ReverseStringWords {
    public String solve(String A) {
        StringBuilder builder = new StringBuilder();
        A = A.trim();
        String [] split = A.split(" ");
        for ( int i = split.length-1; i >= 0; i--) {
            if ( split[i].length()== 0) continue;
            builder.append(split[i]);

            if ( i != 0) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    public static void main(String [] args) {
        System.out.println(new ReverseStringWords().solve("qxkpvo  f   w vdg t wqxy ln mbqmtwwbaegx   mskgtlenfnipsl bddjk znhksoewu zwh bd fqecoskmo"));
    }
}
