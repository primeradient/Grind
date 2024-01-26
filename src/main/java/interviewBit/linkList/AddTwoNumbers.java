package interviewBit.linkList;

import static interviewBit.linkList.FindIntersection.createNode;

public class AddTwoNumbers {
    public int getLen(ListNode A) {
        int len = 0;
        ListNode tmp = A;
        while ( tmp != null ) {
            len++;
            tmp = tmp.next;
        }
        return len;
    }

    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        int len1 = getLen(A);
        int len2 = getLen(B);

        ListNode biggerNode = ( len1 > len2 ) ? A : B;
        ListNode smallerNode = ( len1 <= len2 ) ? A : B;
        ListNode answer = null;
        int carry = 0;
        ListNode nextNode = null;
        while ( smallerNode != null) {
            int sum = biggerNode.val + smallerNode.val + carry;
            int rem = sum % 10;
            carry = sum / 10;
            if ( answer == null ) {
                answer = new ListNode(rem);
                nextNode = answer;
            } else {
                ListNode val = new ListNode(rem);
                nextNode.next  = val;
                nextNode = val;
            }
            smallerNode = smallerNode.next;
            biggerNode = biggerNode.next;
        }

        while ( biggerNode != null) {
            int sum = biggerNode.val + carry;
            int rem = sum % 10;
            carry = sum / 10;

            ListNode val = new ListNode(rem);
            nextNode.next  = val;
            nextNode = val;

            biggerNode = biggerNode.next;
        }


        if ( carry > 0) {
            ListNode val = new ListNode(carry);
            nextNode.next  = val;
        }

        return answer;


    }


    public static void main(String [] args) {
        int [] arr1 = new int[] {9 , 6 , 9};
        int [] arr2 = new int[] {8 , 4 , 8};



        ListNode intersection = new AddTwoNumbers().addTwoNumbers(createNode(arr1), createNode(arr2));
        while  ( intersection != null ) {
            System.out.print(" " + intersection.val);
            intersection = intersection.next;
        }


    }

}
