package lc.lcQuestion;

import java.util.Arrays;

/**
 * Description:
 * date: 2022/3/22 14:08
 *
 * @author huajie.zuo
 */
public class Q253 {
    public int minMeetingRooms(int[][] intervals) {
        int[][] arr=new int[intervals.length*2][2];
        int i=0;
        for (int[] interval : intervals) {
            arr[i++]=new int[]{interval[0],1};
            arr[i++]=new int[]{interval[1],-1};
        }
        Arrays.sort(arr,(a, b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        int max=0;
        int sum=0;
        for (int[] ints : arr) {
            sum+=ints[1];
            max=Math.max(max,sum);
        }
        return max;
    }
}
