package codetop_byte.q0305;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    class ListNode {
        int val;
        ListNode next;

        ListNode (int val) {
            this.val = val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        PriorityQueue<ListNode> p = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        int n = lists.length;
        for(ListNode node : lists){
            if(node != null){
                p.offer(node);
            }
        }
        while(!p.isEmpty()){
            ListNode no = p.poll();
            ListNode curr = new ListNode(no.val);
            cur.next = curr;
            cur = curr;
            if(no.next != null){
                p.offer(no.next);
            }
        }
        return dummy.next;
    }
}
