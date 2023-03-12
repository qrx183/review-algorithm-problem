package codetop_byte.q0312;

public class DetectCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode (int val) {
            this.val = val;
        }
    }
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(slow != fast && slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }else{
                return null;
            }
        }
        if (slow == null || fast == null) {
            return null;
        }
        slow = head;
        while(slow != fast && slow != null && fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
