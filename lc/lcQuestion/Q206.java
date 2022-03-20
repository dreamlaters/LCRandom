package lc.lcQuestion;

import lc.baseDataStructure.ListNode;

public class Q206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        return reverseList2(head,null);
    }

    private ListNode reverseList2(ListNode head, ListNode pre) {
        if(head==null){
            return pre;
        }
        ListNode next=head.next;
        head.next=pre;
        pre=head;
        return reverseList2(next,pre);
    }
}
