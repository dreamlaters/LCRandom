package lc.lcQuestion;

import java.util.LinkedList;
import java.util.List;

public class Q39 {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0,target,candidates,new LinkedList<Integer>());
        return res;
    }

    private void dfs(int index, int target, int[] candidates, LinkedList<Integer> list) {
        if(target<0){
            return;
        }else if(target==0){
            res.add(new LinkedList<>(list));
            return;
        }
        if(target<candidates[index]){
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(i,target-candidates[i],candidates,list);
            list.removeLast();
        }
    }
}
