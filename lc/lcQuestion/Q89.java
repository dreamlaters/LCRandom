package lc.lcQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * date: 2022/3/28 11:53
 *
 * @author huajie.zuo
 */
public class Q89 {
    public List<Integer> grayCode(int n) {
        List<Integer> r=new ArrayList<>();
        r.add(0);
        r.add(1);
        int index=0;
        while (n>=2+index) {
            int size=r.size();
            for (int i = size-1; i >=0; i--) {
                r.add(r.get(i)+(2<<index));
            }
            index++;
        }
        return r;
    }
}
