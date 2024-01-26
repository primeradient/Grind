package interviewBit.linkList;

import static interviewBit.linkList.ReorderList.createList;

public class SortLinkList {


    public ListNode findMiddleNode(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;

        while (  fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode sortList(ListNode a, ListNode b) {
        if ( a== null ) return  b;
        if ( b == null) return  a;

        ListNode result = null;

        if ( a.val <= b.val) {
            result = a;
            result.next = sortList(a.next, b);
        } else {
            result = b;
            result.next = sortList(a, b.next);
        }
        return result;
    }

    public ListNode mergeSort(ListNode A) {
        if ( A == null || A.next == null) {
            return A;
        }

        ListNode mid = findMiddleNode(A);
        ListNode nextofmiddle  = mid.next;
        mid.next = null;

        ListNode left = mergeSort(A);
        ListNode right = mergeSort(nextofmiddle );

        return sortList(left, right);
    }

    public static void main(String [] args) {
        int arr[] = new int[]{1,5,4,3};
        ListNode start = createList(arr);
        ListNode newNode = new SortLinkList().mergeSort(start);
        while ( newNode != null ) {
            System.out.print(" " + newNode.val);
            newNode = newNode.next;
        }
    }
}
