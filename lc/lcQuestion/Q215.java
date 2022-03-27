package lc.lcQuestion;

import java.util.Random;

public class Q215 {
    Random random=new Random();
    int[] nums;
    public int findKthLargest(int[] nums, int k) {
        this.nums=nums;
        return quickSort(0,nums.length-1,nums.length-k);
    }

    public int quickSort(int l,int r,int k) {
        if(l>r){
            return l;
        }
        int wall=getWallAndSwap(l,r);
        if(wall==k){
            return nums[k];
        }else if(wall<k){
            return quickSort(wall+1,r,k);
        }else{
            return quickSort(l,wall-1,k);
        }
    }

    public int getWallAndSwap(int l,int r) {
        int ran=random.nextInt(r-l+1)+l;
        int compare=nums[ran];
        swap(ran,r);
        int wall=l;
        for(int i=l;i<r;i++){
            if(nums[i]<compare){
                if(i!=wall){
                    swap(i,wall);
                }
                wall++;
            }
        }
        swap(wall,r);
        return wall;
    }

    public void swap(int a,int b) {
        int z=nums[a];
        nums[a]=nums[b];
        nums[b]=z;
    }
}
