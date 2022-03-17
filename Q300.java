import java.util.Arrays;

/**
 * Description:
 * date: 2022/3/16 17:16
 *
 * @author huajie.zuo
 */
public class Q300 {
    public int lengthOfLIS(int[] nums) {
        int[] sorted=new int[nums.length];
        Arrays.fill(sorted,-10001);
        int index=0;
        for (int num : nums) {
            if(index==0 || num>sorted[index-1]){
                sorted[index++]=num;
            }else {
                if(num==sorted[index]){
                    continue;
                }else if(num<=sorted[0]){
                    sorted[0]=num;
                }else {
                    int l=0,r=index;
                    int mid=0;
                    while(true){
                        mid=(r-l)/2+l;
                        if(mid==l){
                            if(sorted[l]>=num){
                                sorted[l]=num;
                            }else {
                                sorted[r]=num;
                            }
                            break;
                        }
                        if(sorted[mid]==num){
                            break;
                        }else if(sorted[mid]>num){
                            r=mid;
                        }else {
                            l=mid;
                        }
                    }
                }
            }
        }
        return index;
    }
}
