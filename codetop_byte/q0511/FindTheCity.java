package codetop_byte.q0511;

import java.util.*;

public class FindTheCity {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int m = edges.length;
        List<int[]>[] nxs = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            nxs[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            int s = edge[0],e = edge[1],w = edge[2];
            nxs[s].add(new int[]{e,w});
            nxs[e].add(new int[]{s,w});
        }

        int res = -1,cnt = Integer.MAX_VALUE;
        for(int i = n-1; i >= 0; i--) {
            int curCnt = dijkstra(nxs,i,distanceThreshold,n);
            if(cnt > curCnt) {
                cnt = curCnt;
                res = i;
            }
        }
        return res;
    }

    private int dijkstra(List<int[]>[] nxs,int s,int distanceThreshold,int n) {
        int[] dis = new int[n];
        boolean[] isV = new boolean[n];
        Arrays.fill(dis,0x3f3f3f3f);
        PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        p.offer(new int[]{0,s});
        while(!p.isEmpty()) {
            int[] arr = p.poll();
            int dist = arr[0];
            int start = arr[1];
            isV[start] = true;
            for(int[] ew : nxs[start]) {
                if(!isV[ew[0]] && dis[ew[0]] > dist + ew[1]) {
                    dis[ew[0]] = dist + ew[1];
                    p.offer(new int[]{dis[ew[0]],ew[0]});
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if (i == s) {
                continue;
            }
            if(dis[i] <= distanceThreshold) {
                cnt++;
            }
        }
        return cnt;
    }
}
