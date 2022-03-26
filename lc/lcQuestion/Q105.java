package lc.lcQuestion;

import lc.basicDataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q105 {
    private int[] preOrder;
    private Map<Integer,Integer> map;
    private int preIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder=preorder;
        map=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        preIndex=0;
        return dfs(0,preorder.length-1);
    }

    private TreeNode dfs(int l, int r) {
        if(l>r){
            return null;
        }
        int preNum=preOrder[preIndex++];
        int midIndex=map.get(preNum);
        TreeNode left=dfs(l,midIndex-1);
        TreeNode right=dfs(midIndex+1,r);
        return new TreeNode(preNum,left,right);
    }
}
