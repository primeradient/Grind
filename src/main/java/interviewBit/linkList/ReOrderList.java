package interviewBit.linkList;


import java.util.Stack;

public class ReOrderList {
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
            if ( i > count/2) break;

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

        return start;
    }

    
}
