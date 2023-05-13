package codetop_byte.q0513;

public class NumIslands {
    int m,n;
    boolean[][] isV;
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        isV = new boolean[m][n];
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !isV[i][j]) {
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid,int x,int y) {
        isV[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int r = x + dir[i][0];
            int c = y + dir[i][1];
            if(r >= m || r < 0 || c >= n || c < 0 || isV[r][c] || grid[r][c] != '1') {
                continue;
            }
            dfs(grid,r,c);
        }
    }
}
