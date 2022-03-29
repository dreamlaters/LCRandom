package lc.lcQuestion;

/**
 * Description:
 * date: 2022/3/29 16:02
 *
 * @author huajie.zuo
 */
public class Q152 {
    public int maxProduct(int[] nums) {
        int max=nums[0],min=nums[0],r=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<0){
                int temp=max;
                max=Math.max(nums[i],nums[i]*min);
                min=Math.min(nums[i],nums[i]*temp);
            }else {
                max=Math.max(nums[i],max*nums[i]);
                min=Math.min(nums[i],nums[i]*min);
            }
            r=Math.max(r,max);
        }
        return r;
    }
}
