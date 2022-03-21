package lc.lcQuestion;

import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * date: 2022/3/21 17:47
 *
 * @author huajie.zuo
 */
public class Q305 {
    int[] root;
    int[] size;
    int count=0;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        root=new int[m*n];
        size=new int[m*n];
        boolean[][] c=new boolean[m][n];
        List<Integer> r=new LinkedList<>();
        for (int[] position : positions) {
            int a=position[0],b=position[1];
            if(c[a][b]){
                r.add(count);
                continue;
            }
            count++;
            c[a][b]=true;
            int num=getNum(a,b,n);
            root[num]=num;
            size[num]=1;
            if(a!=0 && c[a-1][b]){
                union(num,getNum(a-1,b,n));
            }
            if(a!=m-1 && c[a+1][b]){
                union(num,getNum(a+1,b,n));
            }
            if(b!=0 && c[a][b-1]){
                union(num,getNum(a,b-1,n));
            }
            if(b!=n-1 && c[a][b+1]){
                union(num,getNum(a,b+1,n));
            }
            r.add(count);
        }
        return r;
    }

    private void union(int a, int b) {
        int ar=find(a);
        int br=find(b);
        if(ar==br){
            return;
        }
        count--;
        if(size[ar]<size[br]){
            root[ar]=br;
            size[br]+=size[ar];
        }else {
            root[br]=ar;
            size[ar]+=size[br];
        }
    }

    private int find(int a) {
        while(a!=root[a]){
            root[a]=root[root[a]];
            a=root[a];
        }
        return a;
    }

    private int getNum(int a, int b, int n) {
        return a*n+b;
    }
}
