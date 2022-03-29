package lc.lcQuestion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description:
 * date: 2022/3/29 14:51
 *
 * @author huajie.zuo
 */
public class Q139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        Set<String> set=new HashSet<>(wordDict);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i]=dp[j] && set.contains(s.substring(j,i));
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[n];
    }
}
