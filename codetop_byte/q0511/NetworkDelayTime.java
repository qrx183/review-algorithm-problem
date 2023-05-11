package codetop_byte.q0511;

import org.junit.jupiter.api.Test;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dis = new int[n+1];
        boolean[] isV = new boolean[n+1];
        Map<Integer, List<int[]>> nxs = new HashMap<>();
        int m = times.length;
        for(int[] time : times) {
            int s = time[0];
            int e = time[1];
            int w = time[2];
            List<int[]> l = nxs.getOrDefault(s,new ArrayList<>());
            l.add(new int[]{e,w});
            nxs.put(s,l);
        }
        Arrays.fill(dis,10000000);
        dis[k] = 0;
        PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        p.offer(new int[]{0,k});

        while(!p.isEmpty()) {
            int[] arr = p.poll();
            int dist = arr[0];
            int start = arr[1];
            isV[k] = true;
            if(nxs.containsKey(start)){
                for(int[] ew : nxs.get(start)) {
                    if(!isV[ew[0]] && dis[ew[0]] > dist + ew[1]) {
                        dis[ew[0]] = dist + ew[1];
                        p.offer(new int[]{dis[ew[0]],ew[0]});
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if(dis[i] == 10000000) {
                return -1;
            }
            ans = Math.max(ans,dis[i]);
        }
        return ans;
    }
    @Test
    public void show() {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(networkDelayTime(times,4,2));
    }
}
