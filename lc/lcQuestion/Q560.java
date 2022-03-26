package lc.lcQuestion;

import java.util.HashMap;
import java.util.Map;

public class Q560 {
    public int subarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        int sum = 0;
        sums[0] = sum;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i + 1] = sum;
        }
        Map<Integer, Integer> map = new HashMap();
        int r = 0;
        for (int i = 0; i < sums.length; i++) {
            r += map.getOrDefault(sums[i] - k, 0);
            map.put(sums[i], map.getOrDefault(sums[i], 0) + 1);
        }
        return r;
    }
}