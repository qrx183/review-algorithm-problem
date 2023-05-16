package graph;

import java.util.*;

public class MinRoad {
    public int bfs(int[][] g,int s,int e) {
        // 权重为1的最短路
        int n = g.length;
        boolean[] isV = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s,1});
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int node = arr[0];
            int step = arr[1];
            if(node == e) {
                return step;
            }
            isV[node] = true;
            for(int nx : g[node]) {
                if(!isV[nx]) {
                    q.offer(new int[]{nx,step+1});
                }
            }
        }
        return -1;
    }
    public int bfs2(int[][] g,int s,int e) {
        // 带权重的最短路
        int n = g.length;
        boolean[] isV = new boolean[n];
        PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        p.offer(new int[]{s,0});
        while(!p.isEmpty()) {
            int[] arr = p.poll();
            int node = arr[0];
            int dis = arr[1];
            if(node == e) {
                return dis;
            }
            isV[node] = true;
            for(int i = 0; i < n;i++) {
                if(!isV[i]) {
                    p.offer(new int[]{i,node+g[node][i]});
                }
            }
        }
        return -1;
    }

    public int dijkstra(int[][] g,int s,int e) {
        // 单源最短路:求1个点到另外任意一个点的距离
        int n = g.length;
        int[] dis = new int[n];
        boolean[] isV = new boolean[n];
        PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        p.offer(new int[]{0,s});
        Arrays.fill(dis,100010);
        dis[s] = 0;
        while(!p.isEmpty()) {
            int[] arr = p.poll();
            int dist = arr[0];
            int start = arr[1];
            isV[start] = true;
            for(int i = 0; i < n; i++) {
                if(!isV[i] && dis[i] > dis[start]+dist) {
                    dis[i] = dis[start]+dist;
                    p.offer(new int[]{dis[i],i});
                }
            }
        }
        return dis[e];
    }
}
