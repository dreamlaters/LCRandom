package lc.lcQuestion;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description:
 * date: 2022/3/29 11:00
 *
 * @author huajie.zuo
 */
public class Q772 {
    static int i = 0;

    public static int calculate(String s) {
        char op = '+';
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char[] cs = s.toCharArray();
        while (i < cs.length) {
            char c = cs[i++];
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c == '(') {
                num = calculate(s);
            }
            if (i == cs.length || c == '+' || c == '-' || c == '*' || c == '/' || c == ')') {
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                op = c;
                num = 0;
            }
            if (c == ')') {
                break;
            }
        }
        int r = 0;
        for (Integer integer : stack) {
            r += integer;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1+9*(1+3/(1+0))"));
    }
}
