package lc.lcQuestion;

import lc.basicDataStructure.ListNode;

public class Q83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode cur=head;
        while (cur.next != null) {
            if(cur.val==cur.next.val){
                cur=cur.next.next;
            }else {
                cur=cur.next;
            }
        }
        return head;
    }
}
