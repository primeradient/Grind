package interviewBit.linkList;

public class DetectCycle {
        /*
       Traverse linked list using two pointers.
        Move one pointer(slow_p) by one and another pointer(fast_p) by two.
        If these pointers meet at the same node then there is a loop. If pointers do not meet then the linked list doesn’t have a loop.
 */

    public ListNode detectCycle(ListNode a) {

        ListNode slow = a;
        ListNode fast = a;
        while (  fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if ( slow == fast) {
                return slow;
            }
        }

        return null;

    }

    public static ListNode createNode(int [] arr) {
        ListNode A = null;
        ListNode start = null;
        ListNode cycle = null;
        ListNode end = null;
        for (int val : arr) {

            if ( start == null)  {
                start = new ListNode(val);
                A = start;
            } else {
                A.next = new ListNode(val);
                A = A.next;
                end = A;
            }
            if ( val == 8 ) {
                cycle = A;
            }
        }
        end.next = cycle;
        return start;
    }

    public static void main(String [] args) {
        int [] arr1 = new int[] {4,1,8,7,9};


        ListNode intersection = new DetectCycle().detectCycle(createNode(arr1));
        if ( intersection != null) {
            System.out.println(intersection.val);
        }


    }

}

