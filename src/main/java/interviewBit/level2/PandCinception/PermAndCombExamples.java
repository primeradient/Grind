package interviewBit.level2.PandCinception;

public class PermAndCombExamples {
    private static long factorial(int n) {
        if ( n == 0 ) return 1;
        else return n * factorial(n-1);
    }

    public static long getPermutations(int n, int r) {
        //formula:  n! / (n – r)!
        return factorial(n) / factorial(n - r);
    }

    public static long getCombinations(int n, int r) {
        //formula:  n! / r!(n – r)!
        return factorial(n) / ( factorial(r) * ( factorial( n-r)));
    }


    public static void main(String []args) {
        System.out.println("Permutation: 7 letters, arrange any 4 letters to form different words : " + getPermutations(7,4));

        System.out.println("\nPermutation: How many 6 digit pin codes can be formed from the digits 0 to 9 if each pin code starts with 48 and no digit is repeated " +
                getPermutations(8, 4));
        //Each starts with 48, so to guess remaining 4 digits out of (10-2), 8 digitis

        System.out.println("\nCombination: Out of 10 students, 4 are to be selected for a trip. In how many ways the selection be made : " + getCombinations(10,4));

        System.out.println("\nCombination: A bag contains 3 red, 5 black, and 4 blue balls. How many ways are there to take out three balls so that each of the colors is taken out : 60" );
        //for Red, pick 1 red:  3
        //for Black, pick 1 black: 5
        //for blue, pick 1 blue: 4
        //So Combinations to get 1 color each from each ball: 3 * 5 * 4 => 60
    }
}
