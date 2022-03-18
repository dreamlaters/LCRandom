import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description:
 * date: 2022/3/18 12:02
 *
 * @author huajie.zuo
 */
public class Q862 {
    public int shortestSubarray(int[] nums, int k) {
        long sum = 0l;
        int n = nums.length;
        long[] sums = new long[n + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n + 1; i++) {
            if (i == 0) {
                sum = 0l;
            } else {
                sum += nums[i - 1];
            }
            sums[i] = sum;
            while (!deque.isEmpty() && sum <= sums[deque.peekLast()]) {
                deque.pollLast();
            }
            while (!deque.isEmpty() && sum - sums[deque.peekFirst()] >= k) {
                min = Math.min(min, i - deque.peekFirst());
                deque.pollFirst();
            }
            deque.addLast(i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
