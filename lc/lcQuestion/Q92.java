package lc.lcQuestion;

import lc.basicDataStructure.ListNode;

public class Q92 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res=new ListNode();
        res.next=head;
        int index=1;
        ListNode pre=res;
        while(index<left){
            pre=pre.next;
            index++;
        }
        ListNode cur=pre.next;
        ListNode next=cur.next;
        while(index<right){
            next=cur.next;
            cur.next=next.next;
            next.next=pre.next;
            pre.next=next;
            index++;
        }
        return res.next;
    }


    public static void main(String[] args) {
        reverseBetween(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null))))),2,4);
    }
}
