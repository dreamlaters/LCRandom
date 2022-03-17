import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description:
 * date: 2022/3/17 15:26
 *
 * @author huajie.zuo
 */
public class Q503 {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n*2];
        for (int i = 0; i < n; i++) {
            arr[i]=nums[i];
            arr[i+n]=nums[i];
        }
        Deque<Integer> stack=new ArrayDeque<>();
        int[] r=new int[n];
        for (int i = 2*n-1; i >=0 ; i--) {
            while(!stack.isEmpty() && arr[i]>=stack.peek()){
                stack.pop();
            }
            if(i<n){
                r[i]=stack.isEmpty()?-1:stack.peek();
            }
            stack.push(arr[i]);
        }
        return r;
    }
}
