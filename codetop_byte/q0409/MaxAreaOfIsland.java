package codetop_byte.q0409;

import org.junit.jupiter.api.Test;

public class MaxAreaOfIsland {
    int ans = 0;
    int tmp = 0;
    boolean[][] isV;
    int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}};
    int m;
    int n;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        isV = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !isV[i][j]) {
                    tmp = 0;
                    isV[i][j] = true;
                    ans = Math.max(ans,dfs(grid,i,j));

                }
            }
        }
        return ans;
    }
    private int dfs(int[][] grid,int i,int j) {
        tmp += 1;
        for (int k = 0; k < 4; k++) {
            int r = i + dir[k][0];
            int c = j + dir[k][1];
            if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != 1 || isV[r][c]) {
                continue;
            }
            isV[r][c] = true;
            dfs(grid,r,c);

        }
        return tmp;
    }
    @Test
    public void show() {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }


}
