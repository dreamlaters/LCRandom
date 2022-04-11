package lc.lcQuestion;

import java.util.Arrays;

/**
 * Description:
 * date: 2022/4/7 16:46
 *
 * @author huajie.zuo
 */
public class Q31 {
    public static void main(String[] args) {
        nextPermutation(new int[]{1,2,3});
    }
    //15421
    //25411
    //21145
    public static void nextPermutation(int[] nums) {
        int index=-1;
        for (int i = nums.length-1; i >=1 ; i--) {
            if(nums[i]>nums[i-1]){
                index=i-1;
                break;
            }
        }
        if(index==-1){
            for (int i = 0; i < nums.length/2; i++) {
                swap(i,nums.length-1-i,nums);
            }
            return;
        }
        for (int i = nums.length-1; i >=0 ; i--) {
            if(nums[i]>nums[index]){
                swap(i,index,nums);
                break;
            }
        }
        for (int i =0; i <(nums.length-index)/2; i++) {
            swap(i+index+1,nums.length-1-i,nums);
        }
    }
    private static void swap(int a,int b,int[] nums){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
