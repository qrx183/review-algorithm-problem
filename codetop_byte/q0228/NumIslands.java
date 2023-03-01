package codetop_byte.q0228;

public class NumIslands {
    // 岛屿数量
    int[][] direct = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
    int res = 0;
    int m;
    int n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j++) {
                if ( grid[i][j] == '1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid,int r, int c) {
        if (grid[r][c] == '0') {
            return;
        }
        grid[r][c] = 0;
        for(int i = 0; i < 4; i++) {
            int x = r + direct[i][0];
            int y = c + direct[i][1];
            if (x >= m || x < 0 || y >= n || y < 0 || grid[x][y] == 0) {
                continue;
            }
            dfs(grid,x,y);
        }
    }
}
