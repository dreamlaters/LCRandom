package lc.lcQuestion;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class Q347 {
    //111443

    //nlogk
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (Integer num : map.keySet()) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] r = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            r[i++] = pq.poll();
        }
        return r;
    }
    //average n
    Random random=new Random();
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] counts=new int[map.size()];
        int i=0;
        for (Integer value : map.values()) {
            counts[i++]=value;
        }
        int min=quickSelect(counts,0,counts.length-1,counts.length-k);
        int[] r=new int[k];
        i=0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()>=min){
                r[i++]=entry.getKey();
            }
        }
        return r;
    }

    private int quickSelect(int[] counts, int l, int r, int k) {
        if(l>r){
            return -1;
        }
        int wall=getWallAndSwap(counts,l,r);
        if(wall==k){
            return counts[k];
        }else if(wall>k){
            return quickSelect(counts,l,wall-1,k);
        }else {
            return quickSelect(counts,wall+1,r,k);
        }
    }

    private int getWallAndSwap(int[] nums, int l, int r) {
        int ran=random.nextInt(r-l+1)+l;
        int compare=nums[ran];
        swap(nums,ran,r);
        int wall=l;
        for (int i = l; i < r; i++) {
            if(nums[i]<compare){
                if(i!=wall){
                    swap(nums,i,wall);
                }
                wall++;
            }
        }
        swap(nums,r,wall);
        return wall;
    }

    private void swap(int[] nums, int a, int b) {
        int z=nums[a];
        nums[a]=nums[b];
        nums[b]=z;
    }
}
