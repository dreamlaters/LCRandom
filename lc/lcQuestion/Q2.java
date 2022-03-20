package lc.lcQuestion;

import lc.baseDataStructure.ListNode;

public class Q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode res=new ListNode();
        ListNode next=res;
        while(l1!=null && l2!=null){
            int sum=l1.val+l2.val+carry;
            if(sum>=10){
                sum-=10;
                carry=1;
            }else {
                carry=0;
            }
            next.next=new ListNode(sum);
            next=next.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int sum=l1.val+carry;
            if(sum>=10){
                sum-=10;
                carry=1;
            }else {
                carry=0;
            }
            next.next=new ListNode(sum);
            next=next.next;
            l1=l1.next;
        }
        while(l2!=null){
            int sum=l2.val+carry;
            if(sum>=10){
                sum-=10;
                carry=1;
            }else {
                carry=0;
            }
            next.next=new ListNode(sum);
            next=next.next;
            l2=l2.next;
        }
        if(carry==1){
            next.next=new ListNode(1);
        }
        return res.next;
    }
}
