package lc.lcQuestion;

public class Q200 {
    int[] root;
    int[] size;
    int count=0;
    public int numIslands(char[][] grid) {
        int width=grid[0].length;
        root=new int[grid.length*width];
        size=new int[grid.length*width];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < width; j++) {
                if(grid[i][j]=='1'){
                    int num=getNum(i,j,width);
                    root[num]=num;
                    size[num]=1;
                    count++;
                    if(i!=grid.length-1 && grid[i+1][j]=='1'){
                        union(num,num+width);
                    }
                    if(j!=width-1 && grid[i][j+1]=='1'){
                        union(num,num+1);
                    }
                }
            }
        }
        return count;
    }
    private int find(int a) {
        while (a!=root[a]){
            root[a]=root[root[a]];
            a=root[a];
        }
        return a;
    }
    private void union(int a, int b) {
        int ar=find(a);
        int br=find(b);
        if (ar==br) {
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

    private int getNum(int i, int j, int width) {
        return i*width+j;
    }
}
