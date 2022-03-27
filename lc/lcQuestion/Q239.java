package lc.lcQuestion;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] r=new int[nums.length-k+1];
        Deque<Integer> deque=new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while(!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            while(!deque.isEmpty() && i-deque.peekFirst()>k){
                deque.pollFirst();
            }
            deque.offer(i);
            if(i>=k-1){
                r[i-k+1]=nums[deque.pollFirst()];
            }
        }
        return r;
    }
}
