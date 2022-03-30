package lc.lcQuestion;

public class Q198 {
    public int rob(int[] nums) {
        int first=0;
        int second=nums[0];
        int r=second;
        for (int i = 2; i <= nums.length; i++) {
            r=Math.max(second,first+nums[i-1]);
            first=second;
            second=r;
        }
        return r;
    }
}
