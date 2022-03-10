
/**
 * Description:
 * date: 2022/3/10 14:26
 *
 * @author huajie.zuo
 */
public class Q450 {
    public Integer getMin(TreeNode right){
        while(right.left!=null){
            right=right.left;
        }
        return right.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root;
        }
        if(key<root.val){
            root.left= deleteNode(root.left,key);
            return root;
        }else if(key>root.val){
            root.right= deleteNode(root.right,key);
            return root;
        }else {
            if(root.left==null && root.right==null){
                return null;
            }else if(root.right==null){
                return root.left;
            }else if(root.left==null){
                return root.right;
            }else {
                int min=getMin(root.right);
                root.val=min;
                root.right=deleteNode(root.right,min);
                return root;
            }
        }
    }
}
