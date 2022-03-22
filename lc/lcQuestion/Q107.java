package lc.lcQuestion;

import lc.basicDataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description:
 * date: 2022/3/18 11:22
 *
 * @author huajie.zuo
 */
public class Q107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> r=new LinkedList<>();
        if(root==null){
            return r;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                root=queue.poll();
                list.add(root.val);
                if(root.left!=null){
                    queue.offer(root.left);
                }
                if(root.right!=null){
                    queue.offer(root.right);
                }
            }
            r.offerFirst(list);
        }
        return r;
    }
}
