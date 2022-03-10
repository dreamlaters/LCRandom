import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * date: 2022/3/10 14:26
 *
 * @author huajie.zuo
 */
public class Q78 {
    List<List<Integer>> r=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0,new LinkedList<>());
        return r;
    }
    public void dfs(int[] num,int index,LinkedList<Integer> list){
        r.add(new LinkedList<>(list));
        if(index==num.length){
            return;
        }
        for (int i = index; i < num.length; i++) {
            list.add(num[i]);
            dfs(num,i+1,list);
            list.removeLast();
        }
    }
}
