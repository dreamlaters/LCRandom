package lc.lcQuestion;

import lc.basicDataStructure.ListNode;

public class Q23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        return merge(lists,0,lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if(l>=r){
            return lists[l];
        }
        int mid=l+(r-l)/2;
        ListNode left=merge(lists,l,mid);
        ListNode right=merge(lists,mid+1,r);
        return merge(left,right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode res=new ListNode();
        ListNode next=res;
        while(left!=null && right!=null){
            if(left.val< right.val){
                next.next=left;
                left=left.next;
            }else {
                next.next=right;
                right=right.next;
            }
            next=next.next;
        }
        next.next=left==null?right:left;
        return res.next;
    }
}
