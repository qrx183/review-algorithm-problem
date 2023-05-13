package codetop_byte.q0513;

public class IslandPerimeter {
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    int m,n;
    public int islandPerimeter(int[][] grid) {
        // 陆地各自的四条边中每条边应该被计算为周长,当且仅当该边相邻边界或水域
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    continue;
                }
                for(int k = 0; k < 4; k++) {
                    int r = i + dir[k][0];
                    int c = j + dir[k][1];
                    if(r >= m || r < 0 || c >= n || c < 0 || grid[r][c] == 0) {
                        res += 1;
                    }
                }
            }
        }
        return res;
    }
}
