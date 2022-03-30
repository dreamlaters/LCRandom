package lc.lcQuestion;

public class Q4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int l=0,r= nums1.length,mid=0,all=nums1.length+nums2.length,b=0;
        while (true) {
            mid=(r-l)/2+l;
            b=(all+1)/2-mid;
            int aL=mid==0?Integer.MIN_VALUE:nums1[mid-1];
            int aR=mid==nums1.length?Integer.MAX_VALUE:nums1[mid];
            int bL=b==0?Integer.MIN_VALUE:nums2[b-1];
            int bR=b==nums2.length?Integer.MAX_VALUE:nums2[b];
            if(aL<=bR && bL<=aR){
                if(all%2==0){
                    return 0.5*(Math.max(aL,bL)+Math.min(aR,bR));
                }else {
                    return Math.max(aL,bL);
                }
            }
            if(aL>bR){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
    }
}
