package lc.lcQuestion;

/**
 * Description:
 * date: 2022/3/29 10:35
 *
 * @author huajie.zuo
 */
public class Q72 {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        char[] mc=word1.toCharArray();
        char[] nc=word2.toCharArray();
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i==0){
                    dp[i][j]=j;
                } else if (j == 0) {
                    dp[i][j]=i;
                }else {
                    if(mc[i-1]==nc[j-1]){
                        dp[i][j]=dp[i-1][j-1];
                    }else{
                        dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    }
                }
            }
        }
        return dp[m][n];
    }
}
