package lc.lcQuestion;

/**
 * Description:
 * date: 2022/3/30 16:03
 *
 * @author huajie.zuo
 */
public class Q283 {
    public void moveZeroes(int[] nums) {
        int l=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                int z=nums[i];
                nums[i]=nums[l];
                nums[l++]=z;
            }
        }
    }
}
