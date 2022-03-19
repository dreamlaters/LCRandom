import java.util.ArrayDeque;
import java.util.Deque;

public class Q84 {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Deque<Integer> stack=new ArrayDeque<>();
        int r=0;
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                int h=heights[stack.pop()];
                int w=stack.isEmpty()?i:i-stack.peek()-1;
                r=Math.max(r,h*w);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int h=heights[stack.pop()];
            int w=stack.isEmpty()?n:n-stack.peek()-1;
            r=Math.max(r,h*w);
        }
        return r;
    }
}
