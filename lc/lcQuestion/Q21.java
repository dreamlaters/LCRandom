package lc.lcQuestion;

import lc.baseDataStructure.ListNode;

public class Q21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res=new ListNode();
        ListNode next=res;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                next.next=list1;
                list1=list1.next;
            }else{
                next.next=list2;
                list2=list2.next;
            }
            next=next.next;
        }
        next.next=list1==null?list2:list1;
        return res.next;
    }
}
