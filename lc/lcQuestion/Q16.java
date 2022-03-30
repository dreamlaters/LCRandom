package lc.lcQuestion;

import java.util.Arrays;

/**
 * Description:
 * date: 2022/3/30 17:02
 *
 * @author huajie.zuo
 */
public class Q16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res=0;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int l=i+1,r=nums.length-1;
            while (l < r) {
                int sum=nums[i]+nums[l]+nums[r];
                int diff;
                if(sum>target){
                    r--;
                    diff=sum-target;
                }else {
                    l++;
                    diff=target-sum;
                }
                if(diff==0){
                    return target;
                }
                if(diff<min){
                    min=diff;
                    res=sum;
                }
            }
        }
        return res;
    }
}
