package lc.lcQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * date: 2022/3/30 10:34
 *
 * @author huajie.zuo
 */
public class Q93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> r=new LinkedList<>();
        int n=s.length();
        for (int i = 1; i <= 3; i++) {
            if(i>n){
                break;
            }
            String a=s.substring(0,i);
            if(!check(a)){
                continue;
            }
            for (int j = 1; j <= 3; j++) {
                if(i+j>n){
                    break;
                }
                String b=s.substring(i,i+j);
                if(!check(b)){
                    continue;
                }
                for (int k = 1; k <=3; k++) {
                    if(i+j+k>n){
                        break;
                    }
                    String c=s.substring(i+j,i+j+k);
                    String d=s.substring(i+j+k);
                    if(!check(c) || !check(d)){
                        continue;
                    }
                    StringBuilder sb=new StringBuilder();
                    sb.append(a).append('.').append(b).append('.').append(c).append('.').append(d);
                    r.add(sb.toString());
                }
            }
        }
        return r;
    }
    private boolean check(String c) {
        if(c.length()>=1 && c.length()<=3){
            int a=Integer.valueOf(c);
            if(0<=a && a<=255 && c.equals(String.valueOf(a))){
                return true;
            }
        }
        return false;
    }
}
