package lc.baseDataStructure;

/**
 * Description:
 * date: 2022/3/10 14:35
 *
 * @author huajie.zuo
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(){
    }
    public TreeNode(int val,TreeNode left,TreeNode right){
        this.left=left;
        this.right=right;
        this.val=val;
    }
}
