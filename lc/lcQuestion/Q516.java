package lc.lcQuestion;

public class Q516 {
    public int longestPalindromeSubseq(String s) {
        char[] cs=s.toCharArray();
        int n=cs.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                int b=j,e=j+i;
                if(i==0){
                    dp[b][e]=1;
                }else{
                    if(cs[b]==cs[e]){
                        dp[b][e]=dp[b+1][e-1]+2;
                    }else{
                        dp[b][e]=Math.max(dp[b][e-1],dp[b+1][e]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
