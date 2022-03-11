/**
 * Description:
 * date: 2022/3/11 11:44
 *
 * @author huajie.zuo
 */
public class Q96 {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;dp[1]=1;
        for (int i = 2; i <= n; i++) {
            for (int left = 0; left <=i-1 ; left++) {
                int right=i-left-1;
                dp[i]+=dp[left]*dp[right];
            }
        }
        return dp[n];
    }
}
