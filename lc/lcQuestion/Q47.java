package lc.lcQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q47 {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,new boolean[nums.length],new LinkedList<>());
        return res;
    }

    private <E> void dfs( int[] nums, boolean[] booleans, LinkedList<Integer> es) {
        if(es.size()==nums.length){
            res.add(new LinkedList<>(es));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(booleans[i]){
                continue;
            }
            if(i!=0 && nums[i]==nums[i-1] && booleans[i-1]){
                continue;
            }
            booleans[i]=true;
            es.add(nums[i]);
            dfs(nums,booleans,es);
            es.removeLast();
            booleans[i]=false;
        }
    }
}
