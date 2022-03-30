package lc.lcQuestion;

import lc.basicDataStructure.ListNode;
import lc.basicDataStructure.TreeNode;

public class Q109 {
    ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        this.head=head;
        return dfs(0,getLength(head)-1);
    }

    private TreeNode dfs(int l, int r) {
        if(l>r){
            return null;
        }
        int mid=(r+l+1)/2;
        TreeNode left=dfs(l,mid-1);
        int val=head.val;
        head=head.next;
        TreeNode right=dfs(mid+1,r);
        return new TreeNode(val,left,right);
    }

    private int getLength(ListNode head) {
        int r=0;
        while (head != null) {
            r++;
            head=head.next;
        }
        return r;
    }
}
