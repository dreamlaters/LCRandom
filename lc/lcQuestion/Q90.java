package lc.lcQuestion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q90 {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0,nums,new LinkedList<Integer>());
        return res;
    }

    private void dfs(int index, int[] nums, LinkedList<Integer> integers) {
        res.add(new LinkedList<>(integers));
        for (int i = index; i < nums.length; i++) {
            if(i!=index && nums[i]==nums[i-1]){
                continue;
            }
            integers.add(nums[i]);
            dfs(i+1,nums,integers);
            integers.removeLast();
        }
    }
}