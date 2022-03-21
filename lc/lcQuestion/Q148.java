package lc.lcQuestion;

import lc.baseDataStructure.ListNode;

/**
 * Description:
 * date: 2022/3/21 17:04
 *
 * @author huajie.zuo
 */
public class Q148 {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode pre=new ListNode(0,head);
        ListNode slow=pre;
        ListNode fast=pre;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode b=slow.next;
        slow.next=null;
        ListNode a=pre.next;
        ListNode ar=mergeSort(a);
        ListNode br=mergeSort(b);
        return merge(ar,br);
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode r=new ListNode();
        ListNode next=r;
        while(a!=null && b!=null){
            if(a.val<b.val){
                next.next=a;
                a=a.next;
            }else {
                next.next=b;
                b=b.next;
            }
            next=next.next;
        }
        next.next=a==null?b:a;
        return r.next;
    }
}
