package lc.lcQuestion;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * date: 2022/3/21 10:40
 *
 * @author huajie.zuo
 */
public class Q146 {
    class LRUCache {
        class Node{
            private int key;
            private int value;
            private Node pre;
            private Node next;
            Node(int key,int value){
                this.key=key;
                this.value=value;
            }
        }
        private Map<Integer,Node> map;
        private int capacity;
        private Node head;
        private Node tail;
        public LRUCache(int capacity) {
            this.capacity=capacity;
            map=new HashMap<>();
            head=new Node(-1,-1);
            tail=new Node(-2,-2);
            head.next=tail;
            tail.pre=head;
        }

        public int get(int key) {
            if(!map.containsKey(key)){
                return -1;
            }
            Node cur=map.get(key);
            cur.pre.next=cur.next;
            cur.next.pre=cur.pre;
            cur.next=head.next;
            head.next.pre=cur;
            head.next=cur;
            cur.pre=head;
            return cur.value;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                map.get(key).value=value;
                get(key);
                return;
            }
            if(map.size()>=capacity){
                Node remove=tail.pre;
                remove.pre.next=tail;
                tail.pre=remove.pre;
                map.remove(remove.key);
            }
            Node cur=new Node(key,value);
            cur.next=head.next;
            head.next.pre=cur;
            head.next=cur;
            cur.pre=head;
        }
    }
}
