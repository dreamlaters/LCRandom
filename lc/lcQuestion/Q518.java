package lc.lcQuestion;

/**
 * Description:
 * date: 2022/4/7 17:45
 *
 * @author huajie.zuo
 */
public class Q518 {
    public static void main(String[] args) {
        System.out.println(change(5,new int[]{1,2,5}));
    }
    //1,2,2,3,4
    public static int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        for (int coin : coins) {
            for (int i = 1; i <=amount; i++) {
                if(i>=coin){
                    dp[i]+=dp[i-coin];
                }
            }
        }
        return dp[amount];
    }
}
