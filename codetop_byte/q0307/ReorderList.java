package codetop_byte.q0307;

import org.junit.jupiter.api.Test;

public class ReorderList {
    class ListNode{
        int val;
        ListNode next;
        ListNode (int val) {
            this.val = val;
        }
    }
    public void reorderList(ListNode head) {
        int len = getLen(head);
        int midLen = len/2;
        ListNode pre = head;
        ListNode cur = head;
        while(midLen != 0) {
            cur = cur.next;
            midLen--;
        }

        ListNode tail = reverse(cur);
        cur.next = null;
        while(tail != cur) {
            ListNode curPre = pre.next;
            ListNode curTail = tail.next;
            pre.next = tail;
            pre = curPre;
            if(pre != cur) {
              tail.next = pre;
            }
            tail = curTail;
        }


    }
    private int getLen(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while(cur != null) {
            cur = cur.next;
            len++;
        }
        return len;
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode end = head.next;
        while(end != null) {
            ListNode tmp = end.next;
            end.next = cur;
            cur = end;
            end = tmp;
        }
        return cur;
    }
    @Test
    public void show(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        reorderList(l1);
    }
}
