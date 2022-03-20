package lc.lcQuestion;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description:
 * date: 2022/3/14 17:41
 *
 * @author huajie.zuo
 */
public class Q739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack=new ArrayDeque<>();
        int[] r=new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[i]>=temperatures[stack.peek()]){
                stack.pop();
            }
            r[i]=stack.isEmpty()?0:stack.peek()-i;
            stack.push(i);
        }
        return r;
    }
}
