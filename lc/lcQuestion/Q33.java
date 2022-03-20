package lc.lcQuestion;

public class Q33 {
    public int search(int[] nums, int target) {
        int mid = 0;
        int left = 0, right = nums.length - 1;
        while (true) {
            mid = (right - left) / 2 + left;
            if (mid == left) {
                if (nums[left] == target) {
                    return left;
                } else if (nums[right] == target) {
                    return right;
                } else {
                    return -1;
                }
            }
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[0]) {
                if (nums[mid] > target) {
                    if (target >= nums[0]) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                } else {
                    left = mid;
                }
            } else {
                if (nums[mid] > target) {
                    right = mid;
                } else {
                    if (target >= nums[0]) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                }
            }
        }

    }
}
