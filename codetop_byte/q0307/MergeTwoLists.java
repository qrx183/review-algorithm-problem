package codetop_byte.q0307;

public class MergeTwoLists {
    class ListNode{
        int val;
        ListNode next;
        ListNode (int val) {
            this.val =val;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curHead = dummy;
        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ListNode cur = new ListNode(list1.val);
                curHead.next = cur;
                curHead = cur;
                list1 = list1.next;
            }else{
                ListNode cur = new ListNode(list2.val);
                curHead.next = cur;
                curHead = cur;
                list2 = list2.next;
            }
        }
        curHead.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}
