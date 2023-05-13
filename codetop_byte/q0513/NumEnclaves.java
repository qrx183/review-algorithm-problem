package codetop_byte.q0513;

public class NumEnclaves {
    int m,n;
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    boolean[][] isV;
    int cnt = 0;
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        isV = new boolean[m][n];
        int sum = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    sum++;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            if(grid[i][0] == 1 && !isV[i][0]) {
                isV[i][0] = true;
                dfs(grid,i,0);
            }
            if(grid[i][n-1] == 1 && !isV[i][n-1]) {
                isV[i][n-1] = true;
                dfs(grid,i,n-1);
            }
        }
        for(int i = 0; i < n; i++) {
            if(grid[0][i] == 1 && !isV[0][i]) {
                isV[0][i] = true;
                dfs(grid,0,i);
            }
            if(grid[m-1][i] == 1 && !isV[m-1][i]) {
                isV[m-1][i] = true;
                dfs(grid,m-1,i);
            }
        }
        return sum-cnt;
    }
    private void dfs(int[][] grid,int x,int y) {
        cnt++;
        for(int i = 0; i < 4; i++) {
            int r = x + dir[i][0];
            int c = y + dir[i][1];
            if(r >= m || r < 0 || c >= n || c < 0 || isV[r][c] || grid[r][c] != 1) {
                continue;
            }
            isV[r][c] = true;
            dfs(grid,r,c);
        }
    }
}
