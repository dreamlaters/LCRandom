package lc.lcQuestion;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description:
 * date: 2022/3/10 14:25
 *
 * @author huajie.zuo
 */
public class Q20 {
    public boolean isValid(String s) {
        Deque<Character> deque=new ArrayDeque<>();
        char[] cs=s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if(cs[i]==')'){
                if(deque.isEmpty() || deque.pop()!='('){
                    return false;
                }
            }else if(cs[i]=='}'){
                if(deque.isEmpty() || deque.pop()!='{'){
                    return false;
                }
            }else if(cs[i]==']'){
                if(deque.isEmpty() || deque.pop()!='['){
                    return false;
                }
            }else {
                deque.push(cs[i]);
            }
        }
        return deque.isEmpty();
    }
}
