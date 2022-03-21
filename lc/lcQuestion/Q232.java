package lc.lcQuestion;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q232 {
    class MyQueue {
        Deque<Integer> stack1;
        Deque<Integer> stack2;
        public MyQueue() {
            stack1=new ArrayDeque<>();
            stack2=new ArrayDeque<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            this.peek();
            return stack2.pop();
        }

        public int peek() {
            if (stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}
