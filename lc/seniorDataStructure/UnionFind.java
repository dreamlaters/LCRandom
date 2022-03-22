package lc.seniorDataStructure;

/**
 * Description:
 * date: 2022/3/22 15:28
 *
 * @author huajie.zuo
 */
public class UnionFind {
    int[] root;
    int[] size;

    public UnionFind(int n) {
        root = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            size[i] = 1;
        }
    }

    public int find(int a) {
        while (a != root[a]) {
            root[a] = root[root[a]];
            a = root[a];
        }
        return a;
    }

    public void union(int a, int b) {
        int ar = find(a);
        int br = find(b);
        if (ar == br) {
            return;
        }
        if (size[ar] < size[br]) {
            root[ar] = br;
            size[br] += size[ar];
        } else {
            root[br] = ar;
            size[ar] += size[br];
        }
    }

}
