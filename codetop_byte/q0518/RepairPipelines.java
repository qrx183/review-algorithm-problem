package codetop_byte.q0518;

import java.util.*;

public class RepairPipelines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        // 型号和位置之间的映射
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] number = new int[n+1];
        List<int[]>[] edges = new List[n+1];
        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
            number[i] = scanner.nextInt();
            List<Integer> l = map.get(number[i]);
            if(l == null) {
                l = new ArrayList<>();
            }
            l.add(i);
            map.put(number[i],l);
        }
        for(int i = 1; i <= k; i++) {
            String s = scanner.next();
            for(int j = 1; j <= s.length(); j++) {
                if(s.charAt(j-1) == '1') {
                    List<Integer> l1 = map.get(i);
                    List<Integer> l2 = map.get(j);

                    for(int be : l1) {
                        for(int en : l2) {
                            edges[be].add(new int[]{en,Math.abs(en-be)});
                        }
                    }
                }
            }
        }
        int[] dis = new int[n+1];
        boolean[] isV = new boolean[n+1];
        PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[1] = 0;
        p.offer(new int[]{1,0});
        isV[1] = true;
        while(!p.isEmpty()) {
            int[] e = p.poll();
            int start = e[0];
            int dist = e[1];
            isV[start] = true;
            for(int[] nxs : edges[start]) {
                int en = nxs[0];
                int dist1 = nxs[1];
                if(dis[en] > dist1+dist && !isV[en]) {
                    dis[en] = dist1+dist;
                    p.offer(new int[]{en,dis[en]});
                }
            }
        }
        if(dis[n] == Integer.MIN_VALUE) {
            System.out.println(-1);
        }else{
            System.out.println(dis[n]);
        }

    }
}
