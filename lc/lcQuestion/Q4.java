package lc.lcQuestion;

public class Q4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        if (l1 > l2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int l = 0, r = l1, mid = 0, bMid = 0, all = l1 + l2;
        while (true) {
            mid = (r - l) / 2 + l;
            bMid = (all + 1) / 2 - mid;
            int al = mid == 0 ? Integer.MIN_VALUE : nums1[mid - 1];
            int ar = mid == l1 ? Integer.MAX_VALUE : nums1[mid];
            int bl = bMid == 0 ? Integer.MIN_VALUE : nums2[bMid - 1];
            int br = bMid == l2 ? Integer.MAX_VALUE : nums2[bMid];
            if (al <=br && bl<=ar) {
                if(all%2==0){
                    return 0.5*(Math.max(al,bl)+Math.min(ar,br));
                }else {
                    return Math.max(al,bl);
                }
            }
            if(al>=br){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
    }
}
