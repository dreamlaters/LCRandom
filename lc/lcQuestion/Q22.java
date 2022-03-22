package lc.lcQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * date: 2022/3/22 11:08
 *
 * @author huajie.zuo
 */
public class Q22 {
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(0,0,n,new StringBuilder());
        return res;
    }

    private void dfs(int l, int r, int n, StringBuilder sb) {
        if(l==n && r==n){
            res.add(sb.toString());
            return;
        }
        if(l<n){
            sb.append('(');
            dfs(l+1,r,n,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(l>r){
            sb.append(')');
            dfs(l,r+1,n,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
