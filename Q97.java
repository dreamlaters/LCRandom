/**
 * Description:
 * date: 2022/3/18 11:14
 *
 * @author huajie.zuo
 */
public class Q97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m=s1.length(),n=s2.length(),k=s3.length();
        if (m+n!=k) {
            return false;
        }
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <=n ; j++) {
                if(i==0 && j==0){
                    dp[0][0]=true;
                }else {
                    if(i==0){
                        dp[i][j]=dp[i][j-1] && s2.charAt(j-1)==s3.charAt(j-1);
                    }else if(j==0){
                        dp[i][j]=dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i-1);
                    }else {
                        dp[i][j]=(dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i-1+j)) || (dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i-1+j));
                    }
                }
            }
        }
        return dp[m][n];
    }
}
