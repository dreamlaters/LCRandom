package lc.lcQuestion;

public class Q91 {
    public int numDecodings(String s) {
        char[] cs=s.toCharArray();
        if(cs[0]=='0'){
            return 0;
        }
        int[] dp=new int[cs.length+1];
        dp[0]=1;
        for (int i = 1; i <= cs.length; i++) {
            if(cs[i-1]!='0'){
                dp[i]+=dp[i-1];
            }
            if(i>=2 && cs[i-2]!='0' && (cs[i-2]-'0')*10+(cs[i-1]-'0')<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[cs.length];
    }
}
