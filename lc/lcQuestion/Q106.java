package lc.lcQuestion;

import lc.basicDataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * date: 2022/3/17 15:53
 *
 * @author huajie.zuo
 */
public class Q106 {
    Map<Integer,Integer> inMap;
    int[] postOrder;
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postOrder=postorder;
        inMap=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i],i);
        }
        postIndex=inorder.length-1;
        return dfs(0,inorder.length-1);
    }
    public TreeNode dfs(int l, int r) {
        if(l>r){
            return null;
        }
        int val=postOrder[postIndex--];
        int mid=inMap.get(val);
        TreeNode right=dfs(mid+1,r);
        TreeNode left=dfs(l,mid-1);
        return new TreeNode(val,left,right);
    }
}
