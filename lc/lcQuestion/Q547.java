package lc.lcQuestion;

/**
 * Description:
 * date: 2022/3/29 11:46
 *
 * @author huajie.zuo
 */
public class Q547 {
    int count;
    int[] root;
    int[] size;
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        count=n;
        root=new int[n];
        size=new int[n];
        for (int i = 0; i < n; i++) {
            root[i]=i;
            size[i]=1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(isConnected[i][j]==1){
                    union(i,j);
                }
            }
        }
        return count;
    }

    private void union(int a, int b) {
        int ar=find(a);
        int br=find(b);
        if (ar == br) {
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
}
