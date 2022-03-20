package lc.lcQuestion;

public class Q48 {
    // 1,2,3    7,4,1
    // 4,5,6    8,5,2
    // 7,8,9    9,6,3
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                swap(i,j,j,i,matrix);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                swap(i,j,i,n-i-1,matrix);
            }
        }
    }

    private void swap(int i, int j, int j1, int i1, int[][] matrix) {
        int z=matrix[i][j];
        matrix[i][j]=matrix[j1][i1];
        matrix[j1][i1]=z;
    }
}
