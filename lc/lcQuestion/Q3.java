package lc.lcQuestion;

/**
 * Description:
 * date: 2022/3/29 17:07
 *
 * @author huajie.zuo
 */
public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        boolean[] exist=new boolean[128];
        int l=0,r=0;
        char[] cs=s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            while(exist[cs[i]]){
                exist[cs[l++]]=false;
            }
            exist[cs[i]]=true;
            r=Math.max(r,i-l+1);
        }
        return r;
    }
}
