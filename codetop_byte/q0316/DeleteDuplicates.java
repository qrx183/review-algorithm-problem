package codetop_byte.q0316;

public class DeleteDuplicates {
    class ListNode{
        int val;
        ListNode next;
        ListNode (int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode curH = dummy;
        ListNode cur = head;
        while(cur != null){
            while (cur != null && cur.next != null && cur.val == cur.next.val) {
                while(cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            }
            if(cur == null) {
                break;
            }
            curH.next = new ListNode(cur.val);
            curH = curH.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
