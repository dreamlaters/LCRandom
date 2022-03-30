package lc.lcQuestion;

import lc.basicDataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * date: 2022/3/30 11:41
 *
 * @author huajie.zuo
 */
public class Q297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return ".";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(',').append(serialize(root.left)).append(',').append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String string : strings) {
            queue.offer(string);
        }
        return dfs(queue);
    }

    private TreeNode dfs(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals(".")) {
            return null;
        }
        TreeNode left = dfs(queue);
        TreeNode right = dfs(queue);
        return new TreeNode(Integer.valueOf(val), left, right);
    }
}
