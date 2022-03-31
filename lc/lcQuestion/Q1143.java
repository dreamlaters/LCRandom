package lc.lcQuestion;

/**
 * Description:
 * date: 2022/3/31 11:07
 *
 * @author huajie.zuo
 */
public class Q1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] a=text1.toCharArray(),b=text2.toCharArray();
        int[][] dp=new int[a.length+1][b.length+1];
        for (int i = 0; i <= a.length; i++) {
            for (int j = 0; j <=b.length ; j++) {
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else {
                    if(a[i-1]==b[j-1]){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else {
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[a.length][b.length];
    }
}
