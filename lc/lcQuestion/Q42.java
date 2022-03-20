package lc.lcQuestion;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q42 {
    public int trap(int[] height) {
        int n=height.length;
        int[] left=new int[n];
        int max=0;
        for (int i = 0; i < n; i++) {
            max=Math.max(max,height[i]);
            left[i]=max;
        }
        max=0;
        int sum1=0,sum2=0;
        for (int i = n-1; i >=0 ; i--) {
            sum1+=height[i];
            max=Math.max(max,height[i]);
            sum2+=Math.min(left[i], max);
        }
        return sum2-sum1;
    }
    public int trap2(int[] height) {
        Deque<Integer> stack=new ArrayDeque<>();
        int r=0;
        for (int i = 0; i < height.length; i++) {
            int now=height[i];
            while(!stack.isEmpty() && now>height[stack.peek()]){
                int d=stack.pop();
                if(!stack.isEmpty()){
                    int h=Math.min(height[stack.peek()],now)-height[d];
                    int w=i-stack.peek()-1;
                    r+=h*w;
                }
            }
            stack.push(i);
        }
        return r;
    }
}
