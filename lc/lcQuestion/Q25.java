package lc.lcQuestion;

import lc.basicDataStructure.ListNode;

public class Q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode r=new ListNode(0,head);
        ListNode pre=r;
        while(head!=null){
            ListNode cur=head;
            for (int i = 0; i < k; i++) {
                if(head==null){
                    return r.next;
                }
                head=head.next;
            }
            ListNode[] headAndTail=reverse(cur,head);
            pre.next=headAndTail[0];
            headAndTail[1].next=head;
            pre=headAndTail[1];
        }
        return r.next;
    }
    private ListNode[] reverse(ListNode cur, ListNode head) {
        ListNode pre=new ListNode(0,cur);
        ListNode next=null;
        while(cur.next!=head){
            next=cur.next;
            cur.next=next.next;
            next.next=pre.next;
            pre.next=next;
        }
        return new ListNode[]{pre.next,cur};
    }
}
