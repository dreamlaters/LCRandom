package lc.lcQuestion;

import lc.baseDataStructure.ListNode;

public class Q25 {
    public static void main(String[] args) {
        reverseKGroup(new ListNode(1,new ListNode(2,null)),2);
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode res=new ListNode();
        res.next=head;
        ListNode pre=res;
        while(head!=null){
            ListNode cur=head;
            for (int i = 0; i < k; i++) {
                if(head==null){
                    return res.next;
                }
                head=head.next;
            }
            ListNode[] headAndTail=reverse(cur,head);
            pre.next=headAndTail[0];
            pre=headAndTail[1];
        }
        return res.next;
    }

    private static ListNode[] reverse(ListNode cur, ListNode head) {
        ListNode pre=new ListNode();
        pre.next=cur;
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
