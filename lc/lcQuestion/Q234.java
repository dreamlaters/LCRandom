package lc.lcQuestion;

import lc.basicDataStructure.ListNode;

public class Q234 {
    public boolean isPalindrome(ListNode head) {
        ListNode mid=findMid(head);
        ListNode r=reverse(mid);
        while(r!=null){
            if(r.val!=head.val){
                return false;
            }
            r=r.next;
            head=head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode mid) {
        ListNode pre=null;
        ListNode next=null;
        while (mid != null) {
            next=mid.next;
            mid.next=pre;
            pre=mid;
            mid=next;
        }
        return pre;
    }

    private ListNode findMid(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
