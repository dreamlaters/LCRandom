package lc.lcQuestion;

/**
 * Description:
 * date: 2022/3/30 9:58
 *
 * @author huajie.zuo
 */
public class Q53 {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(sum<=0){
                sum=nums[i];
            }else {
                sum+=nums[i];
            }
            max=Math.max(max,sum);
        }
        return max;
    }
}
