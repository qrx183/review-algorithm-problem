package codetop_byte.q0509;

import java.util.*;

public class FindMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n,int[][] edges) {
        // 入度为1的点一定不是结果:因为指向该点的点到其他点的距离一定比该点到其他点的距离小1
        // 因此首先排除掉所有入度为1的点,然后对剩下的点再逐一排除度数为1的点,剩下的点即为答案
        if(n==1) return Arrays.asList(0);
        int[] degrees = new int[n];
        List<List<Integer>> nxs = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            nxs.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            int s = edge[0];
            int e = edge[1];
            degrees[e]++;
            degrees[s]++;
            nxs.get(s).add(e);
            nxs.get(e).add(s);
        }

        Deque<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(degrees[i] == 1) {
                q.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();

        while(!q.isEmpty()) {
            res = new ArrayList<>();
            int size = q.size();
            while(size != 0) {
                int cur = q.poll();
                res.add(cur);
                for(int nx : nxs.get(cur)) {
                    degrees[nx]--;
                    if(degrees[nx] == 1){
                        q.offer(nx);
                    }
                }
                size--;
            }
        }
        return res;
    }
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            // O(n2):TL
//        List<Integer> res = new ArrayList<>();
//        Map<Integer,List<Integer>> nxs = new HashMap<>();
//        Map<Integer,Integer> map = new HashMap<>();
//        int min = Integer.MAX_VALUE;
//        for(int[] dir : edges) {
//            List<Integer> l0 = nxs.getOrDefault(dir[0],new ArrayList<>());
//            l0.add(dir[1]);
//            nxs.put(dir[0],l0);
//            List<Integer> l1 = nxs.getOrDefault(dir[1],new ArrayList<>());
//            l1.add(dir[0]);
//            nxs.put(dir[1],l1);
//        }
//        Set<Integer> keys = nxs.keySet();
//        for(int key : keys) {
//            Queue<Integer> q = new LinkedList<>();
//            boolean[] isV = new boolean[n];
//            q.offer(key);
//            isV[key] = true;
//            int cnt = 0;
//            while(!q.isEmpty()) {
//                int size = q.size();
//                cnt+=1;
//                while(size != 0) {
//                    int cur =q.poll();
//                    isV[cur] = true;
//                    if(nxs.get(cur) != null) {
//                        for(int k : nxs.get(cur)) {
//                            if(!isV[k]) {
//                                q.offer(k);
//                            }
//                        }
//                    }
//                    size--;
//                }
//            }
//            min = Math.min(min,cnt);
//            map.put(key,cnt);
//        }
//        if(map.size() == 0) {
//            res.add(0);
//            return res;
//        }
//        for(int key : map.keySet()) {
//            if(map.get(key) == min) {
//                res.add(key);
//            }
//        }
//        return res;
//    }
}
