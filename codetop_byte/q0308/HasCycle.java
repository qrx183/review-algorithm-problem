package codetop_byte.q0308;

public class HasCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode (int val) {
            this.val = val;
        }
    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(slow != fast) {
            slow = slow.next;
            if(fast != null) {
                fast = fast.next;
            }else{
                return false;
            }
            if(fast != null) {
                fast = fast.next;
            }else{
                return false;
            }
        }
        return slow != null;
    }
}
