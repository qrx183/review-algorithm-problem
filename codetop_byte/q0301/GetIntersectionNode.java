package codetop_byte.q0301;

public class GetIntersectionNode {

    class ListNode {
        int val;
        ListNode next;
        ListNode (int val) {
            this.val = val;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = getLenOfList(headA);
        int lenB = getLenOfList(headB);
        ListNode curA = headA;
        ListNode curB = headB;

        if(lenA > lenB) {
            int diff = lenA - lenB;
            while(diff != 0){
                curA = curA.next;
                diff--;
            }
        }else{
            int diff = lenB - lenA;
            while(diff != 0){
                curB = curB.next;
                diff--;
            }
        }
        while (curA != null && curB != null && curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA == curB ? curA : null;
    }
    public int getLenOfList(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }
}
