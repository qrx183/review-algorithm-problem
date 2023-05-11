package graph;

import java.util.Arrays;

public class Kruskal {
    int[] fa;
    public int kruskal(int[][] edges,int n) {
       Arrays.sort(edges,(a,b)->(a[2]-b[2]));
       int ans = 0;
       fa = new int[n];
       for(int i = 0; i < n; i++) {
           fa[i] = i;
       }
       for(int i = 0; i < n; i++) {
           int s = edges[i][0],e = edges[i][1],w = edges[i][2];
           if (find(s) != find(e)) {
               union(s,e);
               ans += w;
           }
       }
       return ans;
    }

    private int find(int x) {
        if(x != fa[x]) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }
    private void union(int x,int y) {
        fa[find(x)] = find(y);
    }
}
