package lc.lcQuestion;

import lc.basicDataStructure.ListNode;

/**
 * Description:
 * date: 2022/3/30 14:26
 *
 * @author huajie.zuo
 */
public class Q143 {
    public static void main(String[] args) {
        reorderList(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4)))));
    }
    public static void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        ListNode mid=getMid(head);
        ListNode right=mid.next;
        mid.next=null;
        ListNode reverse=reverse(right);
        merge(head,reverse);
    }
    private static ListNode getMid(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    private static ListNode reverse(ListNode head){
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
    private static void merge(ListNode a,ListNode b){
        ListNode aa=null;
        ListNode bb=null;
        while(a!=null && b!=null){
            aa=a.next;
            bb=b.next;
            a.next=b;
            b.next=aa;
            a=aa;b=bb;
        }
    }

}
