package interviewBit.arrays;

//or Moore Voting algorithm
public class MajorityElement {

    int findCandidate(int a[], int size) {
        int majorityIndex = 0, count = 1;
        for (int i = 1; i < size; i++) {
            if (a[majorityIndex] == a[i])
                count++;
            else
                count--;

            if (count == 0) {
                majorityIndex = i;
                count = 1;
            }
        }
        return a[majorityIndex];
    }

    /* Function to check if the candidate occurs more
       than n/2 times */
    boolean isMajority(int a[], int size, int cand) {
        int i, count = 0;
        for (i = 0; i < size; i++) {
            if (a[i] == cand)
                count++;
        }
        if (count > size / 2)
            return true;
        else
            return false;
    }

    public void printMajority(int a[], int size) {
        /* Find the candidate for Majority*/
        int cand = findCandidate(a, size);

        /* Print the candidate if it is Majority*/
        if (isMajority(a, size, cand))
            System.out.println(" " + cand + " ");
        else
            System.out.println("No Majority Element");
    }


    public static void main(String[] args) {
        int [] arr = new int[] { 3, 3, 4, 2, 4, 4, 2, 4, 4 };

        new MajorityElement().printMajority(arr, arr.length);
    }
}
