package codetop_byte.q0527;

import java.util.*;

public class SameColorConnection{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer>[] nxs = new List[n+1];
        for(int i = 1; i <= n; i++) {
            nxs[i] = new ArrayList<>();
        }
        int all = 0;
        char[] colors = new char[n+1];
        String s = scanner.next();
        for(int i = 1; i <= n; i++) {
            colors[i] = s.charAt(i-1);
        }
        Map<Integer,Integer> counts = new HashMap<>();
        for(int i = 0; i < n-1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            nxs[a].add(b);
            nxs[b].add(a);
            counts.put(a,counts.getOrDefault(a,0)+1);
            counts.put(b,counts.getOrDefault(b,0)+1);
            if(colors[a] == colors[b]) {
                all += 1;
            }else{
                all += 2;
            }
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[] isV = new boolean[n+1];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            if(nxs[i].size() == 1) {
                isV[i] = true;
                q.offer(new int[]{i,0});
                map.put(i,1);
            }
        }
        all = all - (n-2);
        int res = 0;

        for(int i = 0; i < n-1; i++) {
            int[] cur = q.poll();
            int node = cur[0];
            int w = cur[1]+1;
            isV[node] = true;
            for(int nx : nxs[node]) {
                if(isV[nx]) {
                    continue;
                }
                if(colors[nx] == colors[node]) {
                    map.put(nx,map.getOrDefault(nx,0)+w-1);
                    res += Math.abs(all+1-w-w);
                }else{
                    map.put(nx,map.getOrDefault(nx,0)+w);
                    res += Math.abs(all-w-w);
                }
                counts.put(nx,counts.getOrDefault(nx,0)-1);
                if(counts.get(nx) == 1) {
                    q.offer(new int[]{nx,map.get(nx)});
                }
            }
        }
        System.out.println(res);
    }

}
