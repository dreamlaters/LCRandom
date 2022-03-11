import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * date: 2022/3/11 11:22
 *
 * @author huajie.zuo
 */
public class Q128 {
    Map<Integer,Integer> root=new HashMap<>();
    Map<Integer,Integer> size=new HashMap<>();
    public int longestConsecutive(int[] nums) {
        for (int num : nums) {
            if(!root.containsKey(num)){
                root.put(num,num);
                size.put(num,1);
                if(root.containsKey(num-1)){
                    union(num,num-1);
                }
                if(root.containsKey(num+1)){
                    union(num,num+1);
                }
            }
        }
        int max=0;
        for (Integer v : size.values()) {
            max=Math.max(v,max);
        }
        return max;
    }
    public void union(int a,int b) {
        int ar=find(a);
        int br=find(b);
        if(ar==br){
            return;
        }
        if(size.get(ar)<size.get(br)){
            root.put(ar,br);
            size.put(br,size.get(br)+size.get(ar));
        }else {
            root.put(br,ar);
            size.put(ar,size.get(br)+size.get(ar));
        }
    }
    public int find(int a) {
        while(root.get(a)!=a){
            root.put(a,root.get(root.get(a)));
            a=root.get(a);
        }
        return a;
    }
}
