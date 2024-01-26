package interviewBit.linkList;

import java.util.List;

public class FindIntersection {
        /*
        Get the count of the nodes in the first list, let the count be c1.
        Get the count of the nodes in the second list, let the count be c2.
        Get the difference of counts d = abs(c1 – c2)
        Now traverse the bigger list from the first node to d nodes so that from here onwards both the lists have an equal no of nodes
        Then we can traverse both lists in parallel till we come across a common node. (Note that getting a common node is done by comparing the address of the nodes)
         */

        public ListNode getIntersectionNode(ListNode a, ListNode b) {
            int len1 = 0;
            ListNode tmp = a;
            while ( tmp != null) {
                len1++;
                tmp = tmp.next;
            }
            int len2 = 0;
            tmp = b;
            while ( tmp != null) {
                len2++;
                tmp = tmp.next;
            }


            ListNode longerNode = ( len1 > len2) ? a : b;
            ListNode shorterNode = ( len1 <= len2) ? a : b;
            int mid = Math.abs(len1 - len2);

            int counter = 0;
            tmp = longerNode;
            while ( counter != mid) {
                tmp = tmp.next;
                counter++;
            }


            while ( tmp != null && shorterNode!=null) {
                if ( tmp.val == shorterNode.val) return tmp;
                tmp = tmp.next;
                shorterNode = shorterNode.next;
            }



            return null;

    }

    public static ListNode createNode(int [] arr) {
        ListNode A = null;
        ListNode start = null;
        for (int val : arr) {
            if ( start == null)  {
                start = new ListNode(val);
                A = start;
            } else {
                A.next = new ListNode(val);
                A = A.next;
            }
        }
        return start;
    }

    public static void main(String [] args) {
        int [] arr1 = new int[] {4, 1, 8, 4, 5};
        int [] arr2 = new int[] {5, 6, 1, 8, 4, 5};

        ListNode intersection = new FindIntersection().getIntersectionNode(createNode(arr1), createNode(arr2));
        if ( intersection != null) {
            System.out.println(intersection.val);
        }


    }

}

class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
}