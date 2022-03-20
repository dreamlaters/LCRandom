package lc.lcQuestion;

import lc.baseDataStructure.TreeNode;

/**
 * Description:
 * date: 2022/3/11 11:54
 *
 * @author huajie.zuo
 */
public class Q235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val){
            return lowestCommonAncestor(root, q, p);
        }
        if(q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(p.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }else {
            return root;
        }
    }
}
