package codetop_byte.q0513;

public class LongestIncreasingPath {
    int m,n;
    boolean[][] isV;
    int[][] f;
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    int res = 0;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        isV = new boolean[m][n];
        f = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                f[i][j] = -1;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(matrix,i,j);
            }
        }
        return res;
    }
    private int dfs(int[][] matrix,int x,int y) {
        if(f[x][y] != -1) {
            return f[x][y];
        }
        int cnt = 1;
        isV[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int r = x + dir[i][0];
            int c = y + dir[i][1];
            if (r >= m || r < 0 || c >= n || c < 0 || isV[r][c] || matrix[r][c] <= matrix[x][y]) {
                continue;
            }
            isV[r][c] = true;
            cnt = Math.max(cnt,1+dfs(matrix,r,c));
            isV[r][c] = false;
        }
        res = Math.max(res,cnt);
        f[x][y] = cnt;
        return cnt;
    }
}
