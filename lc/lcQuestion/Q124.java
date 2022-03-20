package lc.lcQuestion;

import lc.baseDataStructure.TreeNode;

public class Q124 {
    int r=-1000;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return r;
    }
    public int dfs(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        left=left<0?0:left;
        right=right<0?0:right;
        int sum=root.val+left+right;
        r=Math.max(r,sum);
        return root.val+Math.max(left,right);
    }
}
