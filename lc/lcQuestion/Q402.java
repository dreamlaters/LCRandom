package lc.lcQuestion;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Q402 {
    public String removeKdigits(String num, int k) {
        char[] cs=num.toCharArray();
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < cs.length; i++) {
            while (k>0 && !stack.isEmpty() && cs[i] < stack.peek()+'0') {
                stack.pop();
                k--;
            }
            stack.push(cs[i]-'0');
        }
        while (k-- > 0 && !stack.isEmpty()) {
            stack.pop();
        }
        StringBuilder stringBuilder=new StringBuilder();
        boolean zero=true;
        for (Integer character : stack) {
            if (zero && character == '0') {
                continue;
            } else if (character != '0') {
                zero=false;
            }
            stringBuilder.append(character);
        }
        return stringBuilder.length()==0?"0":stringBuilder.toString();
    }
}
