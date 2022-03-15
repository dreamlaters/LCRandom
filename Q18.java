import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i < n-3; i++) {
            if(0l+nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                break;
            }
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i+1; j < n-2; j++) {
                if(0l+nums[i]+nums[j]+nums[j+1]+nums[j+2]>target){
                    break;
                }
                if(j!=i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int l=j+1,r=n-1;
                while(l<r){
                    long sum=0l+nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum==target){
                        res.add(List.of(nums[i],nums[j],nums[l],nums[r]));
                    }
                    if(sum>target){
                        while(r!=0 && nums[r]==nums[r-1]){
                            r--;
                        }
                        r--;
                    }else {
                        while(l!=n-1 && nums[l]==nums[l+1]){
                            l++;
                        }
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
