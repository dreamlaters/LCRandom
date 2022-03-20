package lc.lcQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->a[0]-b[0]);
        int begin=intervals[0][0],end=intervals[0][1];
        List<int[]> r=new ArrayList();
        for(int i=1;i<intervals.length;i++){
            if(end>=intervals[i][0]){
                end=Math.max(end,intervals[i][1]);
            }else{
                r.add(new int[]{begin,end});
                begin=intervals[i][0];
                end=intervals[i][1];
            }
        }
        r.add(new int[]{begin,end});
        int[][] res=new int[r.size()][2];
        for(int i=0;i<r.size();i++){
            res[i]=r.get(i);
        }
        return res;
    }
}
