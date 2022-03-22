package lc.lcQuestion;

import lc.basicDataStructure.TreeNode;

/**
 * Description:
 * date: 2022/3/22 17:31
 *
 * @author huajie.zuo
 */
public class Q236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode l=lowestCommonAncestor(root.left,p,q);
        TreeNode r=lowestCommonAncestor(root.right,p,q);
        if(l!=null && r!=null){
            return root;
        }else if(l!=null){
            return l;
        }else {
            return r;
        }
    }
}
