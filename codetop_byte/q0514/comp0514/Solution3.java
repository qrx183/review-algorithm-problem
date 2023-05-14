package codetop_byte.q0514.comp0514;

import java.util.Arrays;

public class Solution3 {
    int[][] dir = {{-1,1},{0,1},{1,1}};
    int m,n;
    boolean[][] isV;
    int[][] f;
    int res = 0;
    public int maxMoves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        isV = new boolean[m][n];
        f = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(f[i],-1);
        }
        for(int i = 0; i < m; i++) {
            dfs(grid,i,0);
        }
        return res;
    }
    private int dfs(int[][] grid,int x,int y) {
        if(f[x][y] != -1) {
            return f[x][y];
        }
        isV[x][y] = true;
        int cnt = 0;
        for(int i = 0; i < 3; i++) {
            int cur = 0;
            int r = x + dir[i][0];
            int c = y + dir[i][1];
            if(r >= m || r < 0 || c >= n || c < 0 || isV[r][c] || grid[r][c] <= grid[x][y]) {
                continue;
            }
            cur = 1 + dfs(grid,r,c);
            cnt = Math.max(cnt,cur);
        }
        res = Math.max(res,cnt);
        f[x][y] = cnt;
        return cnt;
    }
}
