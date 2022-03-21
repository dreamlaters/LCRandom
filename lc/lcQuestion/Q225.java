package lc.lcQuestion;

import java.util.LinkedList;
import java.util.Queue;

public class Q225 {
    class MyStack {
        Queue<Integer> queue;
        public MyStack() {
            queue=new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);
            int size=queue.size();
            while(size>1){
                queue.offer(queue.poll());
                size--;
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
