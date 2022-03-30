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
        ListNode a=head;
        ListNode b=mid.next;
        mid.next=null;
        b=reverse(b);
        merge(a,b);
    }

    private static ListNode reverse(ListNode b) {
        ListNode pre=null;
        ListNode next=null;
        while (b != null) {
            next=b.next;
            b.next=pre;
            pre=b;
            b=next;
        }
        return pre;
    }

    private static void merge(ListNode a, ListNode b) {
        ListNode aa;
        ListNode bb;
        while (a != null) {
            aa = a.next;
            bb = b.next;

            a.next = b;
            a = aa;

            b.next = a;
            b = bb;
        }
    }

    private static ListNode getMid(ListNode head) {
        ListNode slow=head,fast=head;
        while (fast.next != null && fast.next.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

}
