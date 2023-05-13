package codetop_byte.q0513;

import org.junit.jupiter.api.Test;

import java.util.*;

public class ContainsCycle {
    boolean[][] isV;
    int m,n;
    boolean hasRing;
    public boolean containsCycle(char[][] grid) {
        // 每次遍历的时候都不遍历上一次遍历过的方向
        m = grid.length;
        n = grid[0].length;
        isV = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!isV[i][j]) {
                    dfs(grid,i,j,grid[i][j],'L');
                }
                if(hasRing){
                    return true;
                }
            }
        }
        return false;
    }
    private void dfs(char[][] grid,int x,int y,char ch,char from) {
        if(x >= m || x < 0 || y >= n || y < 0 || ch != grid[x][y]) {
            return;
        }
        if(isV[x][y]) {
            hasRing = true;
            return;
        }
        isV[x][y] = true;
        if(from != 'L') dfs(grid,x,y-1,ch,'R');
        if(from != 'R') dfs(grid,x,y+1,ch,'L');
        if(from != 'D') dfs(grid,x+1,y,ch,'U');
        if(from != 'U') dfs(grid,x-1,y,ch,'D');
    }
}
