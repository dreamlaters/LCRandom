package lc.lcQuestion;

import java.util.*;

/**
 * Description:
 * date: 2022/3/22 16:52
 *
 * @author huajie.zuo
 */
public class Q207 {
    public static void main(String[] args) {
        canFinish(5,new int[][]{{1,4},{2,4},{3,1},{3,2}});
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] cd=new int[numCourses];
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            cd[prerequisite[0]]++;
            List<Integer> list=map.getOrDefault(prerequisite[1],new ArrayList<>());
            list.add(prerequisite[0]);
            map.put(prerequisite[1],list);
        }
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < cd.length; i++) {
            if (cd[i]==0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list=map.get(queue.poll());
                numCourses--;
                if(list!=null){
                    for (Integer integer : list) {
                        if(--cd[integer]==0){
                            queue.add(integer);
                        }
                    }
                }
            }
        }
        return numCourses==0;
    }
}
