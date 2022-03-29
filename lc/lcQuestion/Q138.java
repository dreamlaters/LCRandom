package lc.lcQuestion;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * date: 2022/3/29 17:24
 *
 * @author huajie.zuo
 */
public class Q138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node headC = head;
        while (headC != null) {
            map.put(headC, new Node(headC.val));
            headC = headC.next;
        }
        headC = head;
        while (headC != null) {
            map.get(headC).next = map.get(headC.next);
            map.get(headC).random = map.get(headC.random);
            headC = headC.next;
        }
        return map.get(head);
    }
}
