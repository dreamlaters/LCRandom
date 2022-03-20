package lc.lcQuestion;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description:
 * date: 2022/3/10 14:26
 *
 * @author huajie.zuo
 */
public class Q155 {
    class MinStack {
        Deque<int[]> stack;
        int min;
        public MinStack() {
            stack=new ArrayDeque<>();
            min=Integer.MAX_VALUE;
        }

        public void push(int val) {
            min=Math.min(val,min);
            stack.push(new int[]{val,min});
        }

        public void pop() {
            stack.pop();
            if(stack.isEmpty()){
                min=Integer.MAX_VALUE;
            }else {
                min=stack.peek()[1];
            }
        }

        public int top() {
            return stack.peek()[0];
        }

        public int getMin() {
            return stack.peek()[1];
        }
    }
}
