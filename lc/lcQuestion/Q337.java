package lc.lcQuestion;

import lc.basicDataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q337 {
    Map<TreeNode,Integer> map=new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(map.containsKey(root)){
            return map.get(root);
        }
        int rob=root.val;
        if(root.left!=null){
            rob+=rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null){
            rob+=rob(root.right.left)+rob(root.right.right);
        }
        int notRob=rob(root.left)+rob(root.right);
        int r=Math.max(rob,notRob);
        map.put(root,r);
        return r;
    }

    public int rob2(TreeNode root) {
        //0-rob 1-notRob
        int[] result=robDp(root);
        return Math.max(result[0],result[1]);
    }

    private int[] robDp(TreeNode root) {
        if(root==null){
            return new int[]{0,0};
        }
        int[] left=robDp(root.left);
        int[] right=robDp(root.right);
        int rob=root.val+left[0]+right[0];
        int notRob=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return new int[]{notRob,rob};
    }
}
