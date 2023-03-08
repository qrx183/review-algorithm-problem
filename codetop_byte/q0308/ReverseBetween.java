package codetop_byte.q0308;

import org.junit.jupiter.api.Test;

public class ReverseBetween {
    class ListNode {
        int val;
        ListNode next;
        ListNode (int val) {
            this.val = val;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode cur = head;
        ListNode h1 = head,t1 = null,h2 = head,t2 = head;
        int i = 1;
        while(i <= right+1 && cur != null) {
            if(i == left-1){
                h1 = cur;
            }
            if(i == left) {
                h2 = cur;
            }
            if (i == right) {
                t2 = cur;
            }
            if (i == right+1) {
                t1 = cur;
            }
            cur = cur.next;
            i++;
        }
        cur = h2;
        ListNode curr = h2.next;
        while(cur != t2) {
            ListNode nextCur = curr.next;
            curr.next = cur;
            cur = curr;
            curr = nextCur;
        }
        // 需要针对left为初始节点和right为最后一个节点去处理
        h2.next = t1;
        if (h1 != h2) {
            h1.next = t2;
            return head;
        }else{
            return t1;
        }



    }
    @Test
    public void show(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
//        l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5;
        l3.next = l5;
        System.out.println(reverseBetween(l3,1,2));
    }
}
