package lc.lcQuestion;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Description:
 * date: 2022/3/21 11:09
 *
 * @author huajie.zuo
 */
public class Q460 {
    class LFUCache {
        private Map<Integer,Integer> k_v=new HashMap<>();
        private Map<Integer,Integer> k_c=new HashMap<>();
        private Map<Integer, LinkedHashSet<Integer>> c_lru=new HashMap<>();
        private int capacity;
        private int min;
        public LFUCache(int capacity) {
            this.capacity=capacity;
        }

        public int get(int key) {
            Integer value=k_v.get(key);
            if(value==null){
                return -1;
            }
            int count=k_c.get(key);
            k_c.put(key,count+1);
            LinkedHashSet<Integer> lru=c_lru.get(count);
            lru.remove(key);
            if(count==min && lru.isEmpty()){
                min++;
            }
            LinkedHashSet<Integer> lru2=c_lru.getOrDefault(count+1,new LinkedHashSet<>());
            lru2.add(key);
            c_lru.put(count+1, lru2);
            return value;
        }

        public void put(int key, int value) {
            if(capacity==0){
                return;
            }
            if(k_v.containsKey(key)){
                k_v.put(key,value);
                get(key);
                return;
            }
            if(k_v.size()>=capacity){
                LinkedHashSet<Integer> lru=c_lru.get(min);
                Integer remove=lru.iterator().next();
                lru.remove(remove);
                k_v.remove(remove);
                k_c.remove(remove);
            }
            min=1;
            k_v.put(key,value);
            k_c.put(key,1);
            LinkedHashSet<Integer> lru=c_lru.getOrDefault(min,new LinkedHashSet<>());
            lru.add(key);
            c_lru.put(min,lru);
        }
    }
}
