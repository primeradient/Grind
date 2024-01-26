package interviewBit.linkList;

import java.util.Stack;

public class ReorderList {

    public ListNode reorderList(ListNode A) {
        Stack<Integer> stack = new Stack<Integer>();

        if ( A == null ) return null;
        if ( A.next == null ) return A;

        int count = 0;
        ListNode tmp = A;
        while ( tmp != null) {
            tmp = tmp.next;
            count++;
        }

        int i = 0;
        tmp = A;
        while ( tmp != null) {
            if ( count/2 > i) {
                i++;
                tmp = tmp.next;
                continue;
            }
            stack.push(tmp.val);
            i++;
            tmp = tmp.next;
        }

        ListNode start = null;
        ListNode tmpNode = null;
        tmp = A;
        i = 0;

        while ( tmp != null) {

            if ( i >= count/2 ) break;

            ListNode node = new ListNode(tmp.val);
            if ( start == null ) {
                start = node;
                tmpNode = node;
            } else {
                tmpNode.next = node;
                tmpNode = node;
            }

            if (! stack.isEmpty()) {
                ListNode stackNode = new ListNode(stack.pop());
                tmpNode.next = stackNode;

                tmpNode = stackNode;
            }
            tmp = tmp.next;
            i++;
        }
        if (! stack.isEmpty()) {
            ListNode stackNode = new ListNode(stack.pop());
            tmpNode.next = stackNode;
        }
        return start;
    }

    public static void main(String [] args) {
        int arr[] = new int[]{90,94,25,51,45,29,55,63,48,27,72,10,36,68,16,20,31,7,95,70,89,23,22,9,74,71,35,5,80,11,49,92,69,6,37,84,78,28,43,64,96,57,83,13,73,97,75,59,53,52,19,18,98,12,81,24,15,60,79,34,1,54,93,65,44,4,87,14,67,26,30,77,58,85,33,21,46,82,76,88,66,101,61,47,8 };
        ListNode start = createList(arr);
        ListNode newNode = new ReorderList().reorderList(start);
        while ( newNode != null ) {
            System.out.print(" " + newNode.val);
            newNode = newNode.next;
        }
    }

    public static ListNode createList(int [] arr) {
        ListNode start = null;
        ListNode tmp = null;
        for (int val : arr)  {
            if ( start == null) {
                start = new ListNode(val);
                tmp = start;
            } else {
                tmp.next = new ListNode(val);
                tmp = tmp.next;
            }
        }
        return start;
    }
}
