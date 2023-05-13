package codetop_byte.q0513;

import org.junit.jupiter.api.Test;

public class MaxAreaOfIsland {
    int res = 0;
    int m,n;
    boolean[][] isV;
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        isV = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !isV[i][j]) {
                    isV[i][j] = true;
                    res = Math.max(res,dfs(grid,i,j));
                }

            }
        }
        return res;
    }
    private int dfs(int[][] grid, int x, int y) {
        int cnt = 1;
        for(int i = 0; i < 4; i++) {
            int r = x + dir[i][0];
            int c = y + dir[i][1];
            if(r >= m || r < 0 || c >= n || c < 0 || isV[r][c] || grid[r][c] == 0) {
                continue;
            }
            isV[r][c] = true;
            cnt += dfs(grid,r,c);
        }
        return cnt;
    }
    @Test
    public void show() {
        int[][] grid = {{1,0,1},{1,1,1},{0,0,1}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
