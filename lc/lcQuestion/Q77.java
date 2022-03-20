package lc.lcQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * date: 2022/3/18 10:02
 *
 * @author huajie.zuo
 */
public class Q77 {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k,new LinkedList<>());
        return res;
    }
    public void dfs(int index, int n, int k, LinkedList<Integer> list) {
        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            dfs(i+1,n,k,list);
            list.removeLast();
        }
    }
}
