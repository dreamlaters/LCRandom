package lc.lcQuestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q10051 {
    int[] newArr;
    int n;
    public int reversePairs(int[] nums) {
        n = nums.length;
        //这边离散化
        //[7,5,6,4]==>[3,1,2,0]
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy);
        for (int i = 0; i < n; ++i) {
            nums[i] = Arrays.binarySearch(numsCopy, nums[i]);
        }
        newArr = new int[n * 2];
        int r = 0;
        for (int i = n - 1; i >= 0; i--) {
            update(nums[i]);
            r += sumOfRange(0, nums[i] - 1);
        }
        return r;
    }

    private int sumOfRange(int l, int r) {
        int res = 0;
        l += n;
        r += n;
        while (l <= r) {
            if (l % 2 == 1) {
                res += newArr[l++];
            }
            if (r % 2 == 0) {
                res += newArr[r--];
            }
            l /= 2;
            r /= 2;
        }
        return res;
    }

    private void update(int index) {
        index += n;
        while (index >= 1) {
            newArr[index]++;
            index /= 2;
        }
    }
}
