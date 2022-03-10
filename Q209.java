/**
 * Description:
 * date: 2022/3/10 14:26
 *
 * @author huajie.zuo
 */
public class Q209 {
    public int minSubArrayLen(int target, int[] nums) {
        long[] sums=new long[nums.length+1];
        long sum=0;
        sums[0]=sum;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            sums[i+1]=sum;
        }
        int min=Integer.MAX_VALUE;
        int l=0;
        for (int i = 0; i < sums.length; i++) {
            while(sums[i]-sums[l]>=target){
                l++;
                min=Math.min(min,i-l+1);
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
