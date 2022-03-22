package lc.lcQuestion;

import lc.basicDataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q95 {
    public List<TreeNode> generateTrees(int n) {
        int[] arr=new int[n];
        for (int i = 1; i <=n ; i++) {
            arr[i-1]=i;
        }
        return dfs(arr);
    }

    private List<TreeNode> dfs(int[] arr) {
        List<TreeNode> res=new ArrayList<>();
        if(arr.length==0){
            res.add(null);
            return res;
        }
        for (int i = 0; i < arr.length; i++) {
            List<TreeNode> left=dfs(Arrays.copyOfRange(arr,0,i));
            List<TreeNode> right=dfs(Arrays.copyOfRange(arr,i+1,arr.length));
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    res.add(new TreeNode(arr[i],l,r));
                }
            }
        }
        return res;
    }


}
