package lc.lcQuestion;

import lc.basicDataStructure.ListNode;

public class Q82 {
    //[1,2,3,3,4,4,5]
    //[1,1,1,2,3]
    public static void main(String[] args) {
        System.out.println(deleteDuplicates(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3,new ListNode(4
        ,new ListNode(4,new ListNode(5)))))))));
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode res=new ListNode(-101,head);
        ListNode pre=res;
        ListNode cur=head;
        while(cur.next!=null){
            if(cur.val==cur.next.val){
                while (cur.next!=null && cur.val==cur.next.val){
                    cur=cur.next;
                }
                cur=cur.next;
            }else {
                pre.next=cur;
                pre=pre.next;
                cur=cur.next;
            }
        }
        pre.next=cur;
        return res.next;
    }
}
