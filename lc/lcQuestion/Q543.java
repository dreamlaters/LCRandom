package lc.lcQuestion;

import lc.basicDataStructure.TreeNode;

/**
 * Description:
 * date: 2022/3/31 14:41
 *
 * @author huajie.zuo
 */
public class Q543 {
    int res=0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res-1;
    }
    public int dfs(TreeNode root) {
        if(root==null){
            return 0;
        }
        int l=dfs(root.left);
        int r=dfs(root.right);
        res=Math.max(res,l+r+1);
        return Math.max(l,r)+1;
    }
}
