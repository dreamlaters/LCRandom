package lc.lcQuestion;

import java.util.HashSet;

/**
 * Description:
 * date: 2022/3/30 10:05
 *
 * @author huajie.zuo
 */
public class Q752 {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")){
            return 0;
        }
        boolean[] f=new boolean[10000];
        for (String deadend : deadends) {
            f[Integer.valueOf(deadend)]=true;
        }
        if(f[0]){
            return -1;
        }
        int index=1;
        HashSet<String> begin=new HashSet<>();
        begin.add("0000");
        f[0]=true;
        HashSet<String> end=new HashSet<>();
        end.add(target);
        f[Integer.valueOf(target)]=true;
        HashSet<String> next=new HashSet<>();
        while(!begin.isEmpty()){
            next=new HashSet<>();
            for (String b : begin) {
                char[] cs=b.toCharArray();
                for (int i = 0; i < cs.length; i++) {
                    char o=cs[i];
                    char[] changes=changeChar(o);
                    cs[i]=changes[0];
                    String s=String.valueOf(cs);
                    if(end.contains(s)){
                        return index;
                    }
                    if(!f[Integer.valueOf(s)]){
                        f[Integer.valueOf(s)]=true;
                        next.add(s);
                    }

                    cs[i]=changes[1];
                    s=String.valueOf(cs);
                    if(end.contains(s)){
                        return index;
                    }
                    if(!f[Integer.valueOf(s)]){
                        f[Integer.valueOf(s)]=true;
                        next.add(s);
                    }
                    cs[i]=o;
                }
            }
            if(next.size()>end.size()){
                begin=end;
                end=next;
            }else {
                begin=next;
            }
            index++;
        }
        return -1;
    }

    private char[] changeChar(char o) {
        if(o=='0'){
            return new char[]{'9','1'};
        } else if (o == '9') {
            return new char[]{'8','0'};
        }else {
            return new char[]{(char) (o-1), (char) (o+1)};
        }
    }
}
