package lc.lcQuestion;

/**
 * Description:
 * date: 2022/3/29 16:02
 *
 * @author huajie.zuo
 */
public class Q152 {
    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0];
        int r = max;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = min;
                min = Math.min(nums[i], max * nums[i]);
                max = Math.max(nums[i], temp * nums[i]);
            } else {
                min = Math.min(nums[i], min * nums[i]);
                max = Math.max(nums[i], max * nums[i]);
            }
            r = Math.max(r, max);
        }
        return r;
    }
}
