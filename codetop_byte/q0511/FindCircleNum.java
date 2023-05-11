package codetop_byte.q0511;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class FindCircleNum {
    int[] fa;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        fa = new int[n];
        for(int i = 0; i < n; i++) {
            fa[i] = i;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(isConnected[i][j] == 1) {
                    if(find(i) != find(j)) {
                        union(i,j);
                    }
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(fa[i] == i) {
                cnt++;
            }
        }
        return cnt;
    }

    private int find(int x) {
        if(x == fa[x]) {
            return x;
        }
        fa[x] = find(fa[x]);
        return fa[x];
    }

    private void union(int x,int y) {
        fa[find(x)] = find(y);
    }
    @Test
    public void show() {
        int[][] c = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(findCircleNum(c));
    }
}
