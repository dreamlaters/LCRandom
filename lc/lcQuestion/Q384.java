package lc.lcQuestion;

import java.util.Arrays;
import java.util.Random;

public class Q384 {
    class Solution {
        int[] nums;
        int[] origin;
        int n;
        Random random;
        public Solution(int[] nums) {
            this.nums=nums;
            n=nums.length;
            this.origin= Arrays.copyOf(nums,n);
            random=new Random();
        }

        public int[] reset() {
            return origin;
        }

        public int[] shuffle() {
            for (int i = 0; i < n; i++) {
                int ran=random.nextInt(n-i)+i;
                int z=nums[i];
                nums[i]=nums[ran];
                nums[ran]=z;
            }
            return nums;
        }
    }
}
