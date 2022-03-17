/**
 * Description:
 * date: 2022/3/17 16:19
 *
 * @author huajie.zuo
 */
public class Q270 {
    double diff=Double.MAX_VALUE;
    int val=0;
    public int closestValue(TreeNode root, double target) {
        dfs(root,target);
        return val;
    }
    private void dfs(TreeNode root, double target){
        if(root==null){
            return;
        }
        if (root.val==target){
            diff=0;
            val=root.val;
            return;
        }else if(root.val<target){
            if(Math.abs(root.val-target)<diff){
                diff=Math.abs(root.val-target);
                val=root.val;
            }
            dfs(root.right,target);
        }else {
            if(Math.abs(root.val-target)<diff){
                diff=Math.abs(root.val-target);
                val=root.val;
            }
            dfs(root.left,target);
        }
    }
}
