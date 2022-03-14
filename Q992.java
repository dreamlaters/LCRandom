import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * date: 2022/3/14 15:25
 *
 * @author huajie.zuo
 */
public class Q992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return getMost(nums,k)-getMost(nums,k-1);
    }
    public int getMost(int[] nums, int k){
        Map<Integer, Integer> map=new HashMap<>();
        int l=0,r=0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.size()>k){
                if(map.get(nums[l])==1){
                    map.remove(nums[l]);
                }else {
                    map.put(nums[l],map.get(nums[l])-1);
                }
                l++;
            }
            r+=(i-l);
        }
        return r;
    }
}
