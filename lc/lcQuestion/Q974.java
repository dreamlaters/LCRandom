package lc.lcQuestion;

public class Q974 {
    //nums = [4,5,0,-2,-3,1], k = 5
    public static int subarraysDivByK(int[] nums, int k) {
        int sum=0;
        int[] sums=new int[nums.length+1];
        sums[0]=sum;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i]+10000;
            sums[i+1]=sum;
        }
        int[] ys=new int[k];
        int r=0;
        for (int i = 0; i < sums.length; i++) {
            int y=sums[i]%k;
            r+=ys[y];
            ys[y]++;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{4,5,0,-2,-3,1},5));
    }
}
