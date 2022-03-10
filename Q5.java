/**
 * Description:
 * date: 2022/3/10 14:25
 *
 * @author huajie.zuo
 */
public class Q5 {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        char[] cs=s.toCharArray();
        for (int i = 0; i < n; i++) {
            dp[i][i]=true;
            if(i!=n-1 && cs[i]==cs[i+1]){
                dp[i][i+1]=true;
            }
        }
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                int begin=j,end=j+i;
                if(cs[begin]==cs[end] && dp[begin+1][end-1]){
                    dp[begin][end]=true;
                }
            }
        }
        int max=0,b=0,e=0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(dp[i][j] && j-i>max){
                    max=j-i;
                    b=i;
                    e=j;
                }
            }
        }
        return s.substring(b,e+1);
    }
}
