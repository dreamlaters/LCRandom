package lc.lcQuestion;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * date: 2022/3/17 16:42
 *
 * @author huajie.zuo
 */
public class Q76 {
    public String minWindow(String s, String t) {
        Map<Character,Integer> tMap=new HashMap<>();
        char[] tcs=t.toCharArray();
        for (char tc : tcs) {
            tMap.put(tc,tMap.getOrDefault(tc,0)+1);
        }
        char[] scs=s.toCharArray();
        int l=0,min=Integer.MAX_VALUE;
        int effectiveCount=t.length();
        String res="";
        for (int i = 0; i < scs.length; i++) {
            if(tMap.containsKey(scs[i])){
                if(tMap.get(scs[i])>0){
                    effectiveCount--;
                }
                tMap.put(scs[i],tMap.get(scs[i])-1);
                boolean f=false;
                while (effectiveCount<=0) {
                    char lt=scs[l++];
                    if(tMap.containsKey(lt)){
                        tMap.put(lt,tMap.get(lt)+1);
                        if(tMap.get(lt)>0){
                            effectiveCount++;
                        }
                        f=true;
                    }
                }
                if(f && i-l<min){
                    min=i-l;
                    res=s.substring(l-1,i+1);
                }
            }
        }
        return res;
    }
}
