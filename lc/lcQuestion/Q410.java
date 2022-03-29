package lc.lcQuestion;

/**
 * Description:
 * date: 2022/3/29 10:35
 *
 * @author huajie.zuo
 */
public class Q410 {
    //输入：nums = [7,2,5,10,8], m = 2
    //输出：18
    public int splitArray(int[] nums, int m) {
        int sum=0;
        int max=0;
        for (int num : nums) {
            sum+=num;
            max=Math.max(max,num);
        }
        int l=max,r=sum;
        int mid=0;
        while (true) {
            mid=l+(r-l)/2;
            if (mid == l) {
                if(check(l,nums,m)){
                    return l;
                }else {
                    return r;
                }
            }
            if(check(mid, nums, m)){
                r=mid;
            }else {
                l=mid;
            }
        }
    }

    private boolean check(int mid, int[] nums, int m) {
        int sum=0;
        int c=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(sum>mid){
                c++;
                if(c>m){
                    return false;
                }
                sum=nums[i];
            }
        }
        return c < m || (c == m && sum == 0);
    }
}
