package codetop_byte.q0412;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CatMouseGame {
    int[][][] f;
    int m;
    int n;
    int[][] g;
    boolean[][] isV;
    public int catMouseGame(int[][] graph) {
        m = graph.length;
        for(int i = 0; i < m; i++) {
            n = Math.max(n,graph[i].length);
        }
        f = new int[m][m][2*m*m];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(f[i][j],-1);
            }
        }
        g = graph;
        return dfs(1,2,0);
    }
    private  int dfs(int mouse,int cat,int step) {
        if (mouse == 0) {

            return 1;
        }
        if (mouse == cat) {
            return 2;
        }
        if (step >= 2*m*m) {

            return 0;
        }
        if(f[mouse][cat][step] != -1) {
            return f[mouse][cat][step];
        }
        int ans = f[mouse][cat][step];
        if (step % 2 == 0) {
            boolean win = false,p = false;
            for(int i = 0; i < g[mouse].length; i++) {
                int col = g[mouse][i];
                int t = dfs(col,cat,step+1);
                if(t == 1){
                    win = true;
                    break;
                }else if(t == 0) {
                    p = true;
                }
            }
            if (win) {
                ans = 1;
            }else if(p) {
                ans = 0;
            }else {
                ans = 2;
            }
        }else {
            boolean win = false,p = false;
            for(int i = 0; i < g[cat].length; i++) {
                int col = g[cat][i];
                if(col == 0) {
                    continue;
                }
                int t = dfs(mouse,col,step+1);
                if(t == 2){
                    win = true;
                    break;
                }else if (t == 0)  {
                    p = true;
                }
            }
            if (win) {
                ans = 2;
            }else if(p) {
                ans = 0;
            }else {
                ans = 1;
            }
        }
        f[mouse][cat][step] = ans;
        return f[mouse][cat][step];


    }
    @Test
    public void show() {
        int[][] arr = {{1,3},{0},{3},{0,2}};
        System.out.println(catMouseGame(arr));
    }


}
