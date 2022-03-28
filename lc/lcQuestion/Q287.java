package lc.lcQuestion;

public class Q287 {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }
    public static int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index=Math.abs(nums[i])-1;
            if(nums[index]<0){
                return index+1;
            }
            nums[index]=-nums[index];
        }
        return -1;
    }

    public static int findDuplicate2(int[] nums) {
        int fast=nums[0],slow=nums[0];
        while (true) {
            fast=nums[nums[fast]];
            slow=nums[slow];
            if (slow == fast) {
                fast=nums[0];
                while (fast != slow) {
                    fast=nums[fast];
                    slow=nums[slow];
                }
                return slow;
            }
        }
    }
}
