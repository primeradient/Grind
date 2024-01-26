package interviewBit.arrays;

import java.util.ArrayList;
import java.util.Stack;

public class MergeTwoSortedArrays {
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int bigCounter = 0;
        int smallCounter = 0;

        for (int i = 0; i < a.size()+b.size(); i++) {
            if ( smallCounter < a.size() && bigCounter < b.size()) {
                if ( a.get(smallCounter) <= b.get(bigCounter) ) {
                    result.add(a.get(smallCounter));
                    smallCounter++;
                } else {
                    result.add(b.get(bigCounter));
                    bigCounter++;
                }
            } else if ( bigCounter < b.size()) {
                result.add(b.get(bigCounter));
                bigCounter++;
            } else if ( smallCounter < a.size()) {
                result.add(a.get(smallCounter));
                smallCounter++;
            }

        }
        while ( bigCounter < b.size()) {
            result.add(b.get(bigCounter));
            bigCounter++;
        }
        while ( smallCounter < a.size()) {
            result.add(a.get(smallCounter));
            smallCounter++;
        }
        a.clear();
        a.addAll(result);

    }

    public int solve(String A) {

        Stack<Character> stack = new Stack<>();

        for ( int i = 0; i < A.length(); i++) {
            if ( A.charAt(i) == '(') {
                stack.push('(');
            } else if ( A.charAt(i) == ')') {
                char ch = stack.pop();
                if ( ch != '(') {
                    return 0;
                }
            }
        }
        if ( !stack.isEmpty()) return 0;


        return 1;
    }

    public static void main(String [] args) {
        int [] arr1 = new int[]{1,5,8};
        int [] arr2 = new int[]{6,9};

        ArrayList<Integer> a = new ArrayList<>();
        for (int val : arr1) {
            a.add(val);
        }

        ArrayList<Integer> b = new ArrayList<>();
        for (int val : arr2) {
            b.add(val);
        }

        new MergeTwoSortedArrays().merge(a,b);
        for (int val : a){
            System.out.print(" " + val);
        }


    }

}
