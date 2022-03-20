package lc.lcQuestion;

import lc.baseDataStructure.TreeNode;

public class Q98 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long minValue, long maxValue) {
        if(root==null){
            return true;
        }
        if(minValue<root.val && root.val<maxValue){
            return dfs(root.left,minValue,root.val) && dfs(root.right,root.val,maxValue);
        }
        return false;
    }
}
