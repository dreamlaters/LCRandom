package lc.lcQuestion;

import java.util.*;

/**
 * Description:
 * date: 2022/3/30 13:38
 *
 * @author huajie.zuo
 */
public class Q210 {
    public static void main(String[] args) {
        System.out.println(findOrder(2,new int[][]{{1,0}}));
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        int[] outDegree=new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            List<Integer> l=map.getOrDefault(prerequisite[1],new ArrayList<>());
            l.add(prerequisite[0]);
            map.put(prerequisite[1],l);
            outDegree[prerequisite[0]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(outDegree[i]==0){
                queue.offer(i);
            }
        }
        int[] r=new int[numCourses];
        int i=0;
        while (!queue.isEmpty()) {
            int size=queue.size();
            for (int j = 0; j < size; j++) {
                int val=queue.poll();
                r[i++]=val;
                List<Integer> l=map.getOrDefault(val,new ArrayList<>());
                for (Integer integer : l) {
                    if(--outDegree[integer]==0){
                        queue.offer(integer);
                    }
                }
            }
        }
        if(i==numCourses){
            return r;
        }else {
            return new int[0];
        }
    }
}
