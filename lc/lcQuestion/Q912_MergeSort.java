package lc.lcQuestion;

/**
 * Description:
 * date: 2022/1/4 15:40
 *
 * @author huajie.zuo
 */
public class Q912_MergeSort {
    public int[] sortArray(int[] nums){
        return mergeSort(0,nums.length-1,nums);
    }

    private int[] mergeSort(int l, int r, int[] nums) {
        if (l==r) {
            return new int[]{nums[l]};
        }
        int mid=(r-l)/2+l;
        int[] a=mergeSort(l,mid,nums);
        int[] b=mergeSort(mid+1,r,nums);
        return merge(a,b);
    }

    private int[] merge(int[] a, int[] b) {
        int al=0,bl=0,cl=0;
        int[] c=new int[a.length+b.length];
        while(al<a.length && bl<b.length){
            if(a[al]<b[bl]){
                c[cl++]=a[al++];
            }else {
                c[cl++]=b[bl++];
            }
        }
        while (al<a.length) {
            c[cl++]=a[al++];
        }
        while (bl<b.length) {
            c[cl++]=b[bl++];
        }
        return c;
    }
}
