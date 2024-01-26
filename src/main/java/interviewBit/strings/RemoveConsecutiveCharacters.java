package interviewBit.strings;
/*
Problem Description:  Given a string A and integer B, remove all consecutive same characters that have length exactly B.

NOTE : All the consecutive same characters that have length exactly B will be removed simultaneously.

Problem Constraints
1 <= |A| <= 100000
1 <= B <= |A|

Input Format:
First Argument is string A, Second argument is integer B.

Output Format:
Return a string after doing the removals.

Example:

A = "aabcd"
B = 2

Output: "bcd"

*/

public class RemoveConsecutiveCharacters {

    public String solve(String A, int B) {
        String newString = "";
        int charCount = 1;
        int skipCount = 0;

        for (int i = 0; i < A.length(); i++) {
            if ( i+1 < A.length()) {
                if (A.charAt(i) == A.charAt(i + 1)) {
                    charCount++;
                    skipCount++;
                    continue;
                }
            }
            if ( charCount != B ) {
                newString = newString + A.substring(i - skipCount, i+1);
            }
            skipCount=0;
            charCount = 1;
        }
        return newString;
    }


    public static void main(String [] args) {
        System.out.println(new RemoveConsecutiveCharacters().solve( "ppabbpfcc",2));
    }
}
