package lc.lcQuestion;

import lc.basicDataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q257 {
    List<String> res=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,new StringBuilder());
        return res;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        sb.append(root.val);
        String toString=sb.toString();
        if(root.left==null && root.right==null){
            res.add(sb.toString());
            return;
        }else if(root.right==null){
            sb.append('-').append('>');
            dfs(root.left,sb);
        }else if(root.left==null){
            sb.append('-').append('>');
            dfs(root.right,sb);
        }else {
            sb.append('-').append('>');
            dfs(root.left,sb);
            sb=new StringBuilder(toString);
            sb.append('-').append('>');
            dfs(root.right,sb);
        }
    }
}
