package lc.lcQuestion;

import lc.basicDataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> r=new ArrayList<>();
        if(root==null){
            return r;
        }
        boolean isOrder=true;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size=queue.size();
            LinkedList<Integer> bfs=new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode=queue.poll();
                if(treeNode.left!=null){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.offer(treeNode.right);
                }
                if(isOrder){
                    bfs.offerLast(treeNode.val);
                }else {
                    bfs.offerFirst(treeNode.val);
                }
            }
            isOrder=!isOrder;
            r.add(bfs);
        }
        return r;
    }
}
