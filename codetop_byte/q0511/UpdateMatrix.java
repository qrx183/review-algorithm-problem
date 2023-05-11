package codetop_byte.q0511;

import java.util.LinkedList;
import java.util.Queue;

public class UpdateMatrix {
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        // 多源bfs:初始时存入多个起点进入队列
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] isV = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] != 0) {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] != 0) {
                    continue;
                }
                q.offer(new int[]{i,j,0});
                isV[i][j] = true;
            }
        }

        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int x = arr[0],y = arr[1],step = arr[2];
            if(mat[x][y] == 1) {
                res[x][y] = Math.min(res[x][y],step);

            }
            for(int k = 0; k < 4; k++) {
                int r = x + dir[k][0];
                int c = y + dir[k][1];
                if(r >= m || r < 0 || c >= n || c < 0 ||isV[r][c]) {
                    continue;
                }
                isV[r][c] = true;
                q.offer(new int[]{r,c,step+1});
            }
        }

        return res;
    }
}
