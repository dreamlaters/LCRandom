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
        Map<Node,Node> map=new HashMap<>();
        Node copy=head;
        while (copy != null) {
            map.put(copy,new Node(copy.val));
            copy=copy.next;
        }
        copy=head;
        while(copy!=null){
            map.get(copy).next=map.get(copy.next);
            map.get(copy).random=map.get(copy.random);
        }
        return map.get(head);
    }
}
