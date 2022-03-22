package lc.lcQuestion;

import java.util.Random;

/**
 * Description:
 * date: 2022/1/4 15:41
 *
 * @author huajie.zuo
 */
public class Q912_QuickSort {
    Random random=new Random();
    public int[] sortArray(int[] nums){
        quickSort(0,nums.length-1,nums);
        return nums;
    }

    private void quickSort(int l, int r, int[] nums) {
        if (l<r) {
            int wall=getWallAndSwap(l,r,nums);
            quickSort(l,wall,nums);
            quickSort(wall+1,r,nums);
        }
    }

    private int getWallAndSwap(int l, int r, int[] nums) {
        int ran=random.nextInt(r-l+1)+l;
        int compare=nums[ran];
        swap(ran,r,nums);
        int wall=l;
        for (int i = l; i < r; i++) {
            if (nums[i]<compare) {
                if (i != wall) {
                    swap(i,wall,nums);
                }
                wall++;
            }
        }
        swap(wall,r,nums);
        return wall;
    }

    private void swap(int a, int b, int[] nums) {
        int z=nums[a];
        nums[a]=nums[b];
        nums[b]=z;
    }

}
