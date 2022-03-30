package lc.lcQuestion;

import java.util.Arrays;

public class Q322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        Arrays.sort(coins);
        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if(i-coin>=0){
                    if(dp[i-coin]!=Integer.MAX_VALUE){
                        dp[i]=Math.min(dp[i],dp[i-coin]+1);
                    }
                }else{
                    break;
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
