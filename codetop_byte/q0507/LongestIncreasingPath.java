package codetop_byte.q0507;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LongestIncreasingPath {

    boolean[][] isV;
    int[][] f;
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    int res = 0;
    int m,n;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        isV = new boolean[m][n];
        f = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(f[i],-1);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                isV[i][j] = true;
                dfs(matrix,i,j);
                isV[i][j] = false;
            }
        }
        return res;
    }

    private int dfs(int[][] matrix,int r,int c) {
        if(f[r][c] != -1) {
            return f[r][c];
        }
        int result = 1;
        for(int i = 0; i < 4; i++) {
            int ans = 1;
            int x = r +dir[i][0];
            int y = c + dir[i][1];
            if(x >= m || x < 0 || y >= n || y < 0 || isV[x][y] || matrix[x][y] <= matrix[r][c]) {
                continue;
            }
            isV[x][y] = true;
            ans += dfs(matrix,x,y);
            isV[x][y] = false;
            result = Math.max(result,ans);
        }
        res = Math.max(res,result);
        f[r][c] = result;
        return result;
    }
    @Test
    public void show() {
        int[][] ma = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(longestIncreasingPath(ma));
    }
}
