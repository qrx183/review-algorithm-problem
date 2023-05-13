package codetop_byte.q0513;

import org.junit.jupiter.api.Test;

import java.util.*;

public class PacificAtlantic {
    boolean[][] isV;
    boolean[][] f;
    int m,n;
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    List<List<Integer>> res = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    boolean isP,isA;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        isV = new boolean[m][n];
        f = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                isP = i == 0 || j == 0;
                isA = i == m-1 || j == n-1;
                dfs(heights,i,j);
                if(isA && isP) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    private boolean dfs(int[][] heights,int x,int y) {
        if(x == 0 || y == 0) {
            isP = true;
        }
        if(x == m-1 || y == n-1) {
            isA = true;
        }
        if(isA && isP) {
            return true;
        }

        for(int i = 0; i < 4; i++) {
            int r = x + dir[i][0];
            int c = y + dir[i][1];
            if(r >= m || r < 0 || c >= n || c < 0 || isV[r][c] || heights[r][c] > heights[x][y]) {
                continue;
            }
            isV[r][c] = true;
            dfs(heights,r,c);
            isV[r][c] = false;
            if(isA && isP) {
                return true;
            }
        }
        return false;
    }
    @Test
    public void show() {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(heights));
    }
}
