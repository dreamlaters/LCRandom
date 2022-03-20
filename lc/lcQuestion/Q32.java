package lc.lcQuestion;

public class Q32 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("))))())()()(()"));
    }
    public static int longestValidParentheses(String s) {
        char[] cs=s.toCharArray();
        int l=0;
        int r=0;
        int res=0;
        for (int i = 0; i < cs.length; i++) {
            if(cs[i]=='('){
                l++;
            }else {
                r++;
                if(l==r){
                    res=Math.max(res,2*r);
                }else if(r>l){
                    l=0;
                    r=0;
                }
            }
        }
        l=0;
        r=0;
        for (int i = cs.length-1; i >=0; i--) {
            if(cs[i]==')'){
                l++;
            }else {
                r++;
                if(l==r){
                    res=Math.max(res,2*r);
                }else if(r>l){
                    l=0;
                    r=0;
                }
            }
        }
        return res;
    }
}
