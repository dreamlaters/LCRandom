import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q428 {
    class Node {
        private int val;
        private List<Node> children;

        Node() {
        }

        Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    class Codec {
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            if(root==null){
                return ".";
            }
            StringBuilder sb=new StringBuilder();
            sb.append(root.val);
            if(root.children!=null && root.children.size()!=0){
                sb.append(',').append(root.children.size());
                for (Node child : root.children) {
                    sb.append(',').append(serialize(child));
                }
            }else{
                sb.append(',').append(0);
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            String[] strings=data.split(",");
            Queue<String> queue=new LinkedList<>();
            for (String s : strings) {
                queue.offer(s);
            }
            return dfs(queue);
        }

        private Node dfs(Queue<String> queue) {
            String first=queue.poll();
            if(".".equals(first)){
                return null;
            }
            int size=Integer.valueOf(queue.poll());
            List<Node> children=new LinkedList<>();
            for (int i = 0; i < size; i++) {
                children.add(dfs(queue));
            }
            return new Node(Integer.valueOf(first),children);
        }
    }
}
