package lc.lcQuestion;

import lc.baseDataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * date: 2022/3/14 17:30
 *
 * @author huajie.zuo
 */
public class Q144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> r=new LinkedList<>();
        if(root==null){
            return r;
        }
        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root=stack.pop();
            r.add(root.val);
            if(root.right!=null){
                stack.push(root.right);
            }
            if(root.left!=null){
                stack.push(root.left);
            }
        }
        return r;
    }
}
