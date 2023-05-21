package codetop_byte.q0521;

import org.junit.jupiter.api.Test;

import java.util.*;

public class ModifiedGraphEdges {
    List<int[]> list = new ArrayList<>();
    int[][] dis;
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        dis = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        int[][] f = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(f[i],Integer.MAX_VALUE);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int w = edges[i][2];
            dis[a][b] = w;
            dis[b][a] = w;
            f[a][b] = w;
            f[b][a] = w;
        }
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(f[i][k] != Integer.MAX_VALUE && f[k][j] != Integer.MAX_VALUE) {
                        if(f[i][k]+f[k][j] < f[i][j]) {
                            f[i][j] = f[i][k]+f[k][j];
                            map.put(i*n+j,k);
                        }
                    }
                }
            }
        }
        func1(map,source,destination,n);
        if(f[source][destination] == target && list.size() == 0) {
            // 随便赋值
            for(int i = 0; i < edges.length; i++) {
                if(edges[i][2] == -1) {
                    edges[i][2] = 1;
                }
            }
            return edges;
        }
        if(!(list.size() > 0 && f[source][destination] +list.size()*2 < target )) {
            return new int[0][];
        }
        int diff = target - f[source][destination]-list.size();
        for(int i = 0; i < list.size(); i++) {
            int a = list.get(i)[0];
            int b = list.get(i)[1];
            if (i == list.size()-1) {
                dis[a][b] = diff;
                dis[b][a] = diff;
            }else{
                dis[a][b] = 1;
                dis[b][a] = 1;
            }
        }
        for(int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            edges[i][2] = dis[a][b];
        }
        for(int i = 0; i < edges.length; i++) {
            if(edges[i][2] == -1) {
                edges[i][2] = 1;
            }
        }
        return edges;

    }
    private void func1(Map<Integer,Integer> map,int l,int r,int n) {
        if(l != r) {
            if(map.get(l*n+r) != null) {
                int k = map.get(l*n+r);
                if(dis[l][k] == -1) {
                    list.add(new int[]{l,k});
                }
                if(dis[k][r] == -1) {
                    list.add(new int[]{k,r});
                }
                func1(map,l,k,n);
                func1(map,k,r,n);
            }
        }
    }
    @Test
    public void show() {
        int n = 5,s = 0,e = 1, t= 5;
        int[][] edges = {{4,1,-1},{2,0,-1},{0,3,-1},{4,3,-1}};
        System.out.println(Arrays.deepToString(modifiedGraphEdges(n, edges, s, e, t)));
    }
}
