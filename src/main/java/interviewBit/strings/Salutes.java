package interviewBit.strings;

/*
In a long hallway some soldiers are walking from left to right and some from right to left all at the same speed.

Every time while walking they cross through another soldier they salute and move ahead.

Given a string A of length N showing the soldiers' direction they are walking.
'<' denotes a soldier is walking from right to left, and '>' denotes a soldier is walking from left to right.
Return the number of Salutes done.



Problem Constraints
1 <= N <= 105
A = {'<', '>'}

A = '>>><<<'
Output: 9

Soldier 1 will salute with 4, 5, 6. Same goes for soldier 2 and 3.
Hence, the total number of salutes is 9.
 */
public class Salutes {
    /**

     Starting from end, count at each position, the number of '<' ahead.
     then Start from 0, and for every '>', add number of '<' ahead at that index position

     */
    public Long countSalutes(String A) {
        int arr[] = new int[A.length()];
        int counter = 0;
        for (int i = A.length()-1; i > 0; i--) {
            if ( A.charAt(i) == '<') {
                counter++;
            }
            arr[i-1] = counter;
        }
        long result = 0;

        for (int i = 0; i < A.length(); i++) {
            if ( A.charAt(i) == '>') {
                result += arr[i];
            }
        }

        return result;
    }

    public static void main(String [] args) {
        System.out.println(new Salutes().countSalutes(">>>><<<<<<"));
    }
}
