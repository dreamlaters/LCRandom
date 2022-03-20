package lc.lcQuestion;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q426 {
    class Node {
        private int val;
        private Node left;
        private Node right;

        Node() {
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }
        Node pre=null,head=null;
        Deque<Node> stack=new ArrayDeque<>();
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(pre==null){
                head=root;
                pre=root;
            }else {
                root.left=pre;
                pre.right=root;
                pre=root;
            }
            root=root.right;
        }
        head.left=pre;
        pre.right=head;
        return head;
    }
}
