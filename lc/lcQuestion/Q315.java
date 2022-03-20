package lc.lcQuestion;

import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * date: 2022/3/17 17:47
 *
 * @author huajie.zuo
 */
public class Q315 {
    int diff=20001;
    int min=10000;
    public List<Integer> countSmaller(int[] nums) {
        int max=-10000;
        for (int num : nums) {
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        diff=max-min+1;
        int[] arr=new int[2*diff];
        LinkedList<Integer> list=new LinkedList<>();
        for (int i = nums.length-1; i >=0; i--) {
            nums[i]+=(-min);
            update(arr,nums[i]);
            list.offerFirst(sum(0,nums[i]-1,arr));
        }
        return list;
    }
    public void update(int[] arr,int index) {
        index+=diff;
        while(index>=1){
            arr[index]++;
            index/=2;
        }
    }

    public int sum(int l,int r,int[] arr) {
        int res=0;
        l+=diff;r+=diff;
        while(l<=r){
            if(l%2==1){
                res+=arr[l++];
            }
            if(r%2==0){
                res+=arr[r--];
            }
            l/=2;r/=2;
        }
        return res;
    }
}
