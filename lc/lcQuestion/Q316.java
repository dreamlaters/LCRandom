package lc.lcQuestion;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q316 {
    public String removeDuplicateLetters(String s) {
        int[] lastMap=new int[26];
        char[] cs=s.toCharArray();
        for(int i=0;i<cs.length;i++){
            lastMap[cs[i]-'a']=i;
        }
        Deque<Character> stack=new ArrayDeque();
        boolean[] f=new boolean[26];
        for(int i=0;i<cs.length;i++){
            if(!f[cs[i]-'a']){
                f[cs[i]-'a']=true;
                while(!stack.isEmpty() && cs[i]<=stack.peek() && lastMap[stack.peek()-'a']>i){
                    f[stack.pop()-'a']=false;
                }
                stack.push(cs[i]);
            }

        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
