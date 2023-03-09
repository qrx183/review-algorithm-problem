package codetop_byte.q0309;

import org.junit.jupiter.api.Test;

public class SortList {
    class ListNode {
        int val;
        ListNode next;
        ListNode (int val){
            this.val = val;
        }
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = getLenOfNode(head);
        merge(head,0,len-1);
        return head;
    }

    private void merge(ListNode head,int l, int r) {
       if (l < r) {
           int mid = l + r >> 1;
           merge(head,l,mid);
           merge(head,mid+1,r);
           // 方法是可以的,但是可能有更优的做法
           // 在每次获取中间节点的时候不用每次都从头往前找.可以根据找中间节点的方式(快慢指针)一次遍历获取l,mid,r节点
           ListNode lNode = getNodeByIndex(head,l);
           ListNode mNode = getNodeByIndex(head,mid);
           ListNode rNode = getNodeByIndex(head,r);
           mergeTwoList(lNode,mNode,rNode);
       }
    }

    private void mergeTwoList(ListNode h1,ListNode t1,ListNode t2) {
        ListNode h2 = t1.next;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode curH1 = h1;
        ListNode curH2 = h2;
        while(curH1 != t1.next && curH2 != t2.next) {
            if (curH1.val < curH2.val) {
                ListNode curN = new ListNode(curH1.val);
                cur.next = curN;
                cur = curN;
                curH1 = curH1.next;
            }else{
                ListNode curN = new ListNode(curH2.val);
                cur.next = curN;
                cur = curN;
                curH2 = curH2.next;
            }
        }
        if (curH1 == t1.next) {
            while(curH2 != t2.next) {
                ListNode curN = new ListNode(curH2.val);
                cur.next = curN;
                cur = curN;
                curH2 = curH2.next;
            }
        }else{
            while(curH1 != t1.next) {
                ListNode curN = new ListNode(curH1.val);
                cur.next = curN;
                cur = curN;
                curH1 = curH1.next;
            }
        }
        cur = dummy.next;
        curH1 = h1;
        while(curH1 != t2.next) {
            curH1.val = cur.val;
            curH1 = curH1.next;
            cur = cur.next;
        }
    }

    private int getLenOfNode(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    private ListNode getNodeByIndex(ListNode head,int index) {
        int i = 0;
        ListNode cur = head;
        while(i < index) {
            cur = cur.next;
            i++;
        }
        return cur;
    }
    @Test
    public  void show() {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        l1.next = l2; l2.next = l3; l3.next = l4;
        System.out.println(sortList(l1));
    }
}
