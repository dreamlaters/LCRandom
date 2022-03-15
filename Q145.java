import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> r=new LinkedList<>();
        if(root==null){
            return r;
        }
        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root=stack.pop();
            r.addFirst(root.val);
            if(root.left!=null){
                stack.push(root.left);
            }
            if(root.right!=null){
                stack.push(root.right);
            }
        }
        return r;
    }
}
