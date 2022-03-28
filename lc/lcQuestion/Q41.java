package lc.lcQuestion;

public class Q41 {
    /**
     * [3,4,-1,1]
     * [1,2,3,4]
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            while(nums[i]>=1 && nums[i]<=n && nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }
        for (int i = 0; i < n; i++) {
            if(i!=nums[i]-1){
                return i+1;
            }
        }
        return n+1;
    }

    private void swap(int[] nums, int a, int b) {
        int z=nums[a];
        nums[a]=nums[b];
        nums[b]=z;
    }
}
