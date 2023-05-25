package codetop_byte.q0525.meituan;

import java.util.*;

public class Pylon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 擦,这
        int n = scanner.nextInt();
        // dis[i][j] 表示i-j的距离
        int[] f = new int[n+1];
        for(int i = 1; i <= n; i++) {
            f[i] = scanner.nextInt();
        }
        List<Integer>[] dis = new List[n+1];
        for(int i = 1; i <= n; i++) {
            dis[i] = new ArrayList<>();
        }
        for(int i = 1; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            dis[a].add(b);
            dis[b].add(a);

        }
        int[] res = new int[n+1];
        for(int i = 1; i <= n; i++) {
            Queue<int[]> q = new LinkedList<>();
            boolean[] isV = new boolean[n+1];
            isV[i] = true;
            q.offer(new int[]{i,0});
            while(!q.isEmpty()) {
                int[] cur = q.poll();
                int node = cur[0];
                int w = cur[1];
                if(w > f[i]) {
                    break;
                }
                res[node] += 1;
                for(int nx : dis[node]) {
                    if(isV[nx]) {
                        continue;
                    }
                    isV[nx] = true;
                    q.offer(new int[] {nx,w+1});
                }
            }
        }
        for(int i = 1; i <= n; i++) {
            if(i != n) {
                System.out.print(res[i] + " ");
            }else {
                System.out.print(res[i]);
            }
        }
    }
}
