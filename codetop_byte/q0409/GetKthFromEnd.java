package codetop_byte.q0409;

public class GetKthFromEnd {
    class ListNode {
        int val;
        ListNode next;
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        while(k != 0) {
            cur = cur.next;
            k--;
        }
        ListNode curr = head;
        while(cur != null) {
            curr = curr.next;
            cur = cur.next;
        }
        return curr;
    }
}
