package codetop_byte.q0513;

public class Solve {
    boolean[][] isV;
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    int m,n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        isV = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {
                dfs(board,i,0);
            }
            if(board[i][n-1] == 'O') {
                dfs(board,i,n-1);
            }
        }
        for(int i = 0; i < n; i++) {
            if(board[0][i] == 'O') {
                dfs(board,0,i);
            }
            if(board[m-1][i] == 'O') {
                dfs(board,m-1,i);
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'Q') {
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] board, int x, int y) {
        board[x][y] = 'Q';
        isV[x][y] = true;
        for(int i = 0; i < 4; i++){
            int r = x + dir[i][0];
            int c = y + dir[i][1];
            if(r >= m || r < 0 || c >= n || c < 0 || isV[r][c] || board[r][c] != 'O') {
                continue;
            }
            dfs(board,r,c);
        }
    }
}
