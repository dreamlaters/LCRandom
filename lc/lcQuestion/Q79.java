package lc.lcQuestion;

public class Q79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] f=new boolean[board.length][board[0].length];
        char first=word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]==first){
                    f[i][j]=true;
                    if (dfs(board, i, j, f, word, 1)) {
                        return true;
                    }
                    f[i][j]=false;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, boolean[][] f, String word, int index) {
        if(index==word.length()){
            return true;
        }
        char c=word.charAt(index);
        //up
        if(i!=0 && !f[i-1][j] && c==board[i-1][j]){
            f[i-1][j]=true;
            boolean f1=dfs(board,i-1,j,f,word,index+1);
            if(f1){
                return true;
            }
            f[i-1][j]=false;
        }
        //down
        if(i!=board.length-1 && !f[i+1][j] && c==board[i+1][j]){
            f[i+1][j]=true;
            boolean f1=dfs(board,i+1,j,f,word,index+1);
            if(f1){
                return true;
            }
            f[i+1][j]=false;
        }
        //left
        if(j!=0 && !f[i][j-1] && c==board[i][j-1]){
            f[i][j-1]=true;
            boolean f1=dfs(board,i,j-1,f,word,index+1);
            if(f1){
                return true;
            }
            f[i][j-1]=false;
        }
        //right
        if(j!=board[0].length-1 && !f[i][j+1] && c==board[i][j+1]){
            f[i][j+1]=true;
            boolean f1=dfs(board,i,j+1,f,word,index+1);
            if(f1){
                return true;
            }
            f[i][j+1]=false;
        }
        return false;
    }
}
