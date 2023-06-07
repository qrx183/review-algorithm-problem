package codetop_byte.q0606;

import java.util.*;

public class SiteDeployment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        List<Integer>[] nxs = new List[n];
        int[] inDegree = new int[n];
        for(int i = 0; i < n; i++) {
            nxs[i] = new ArrayList<>();
        }
        for(int i = 0; i < r; i++) {
            int e = scanner.nextInt();
            int s = scanner.nextInt();
            nxs[s].add(e);
            inDegree[e]++;
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] isV = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
                isV[i] = true;
            }
        }
        int res = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size != 0) {
                int node = q.poll();
                for (int nx : nxs[node]) {
                    inDegree[nx]--;
                    if(inDegree[nx] == 0) {
                        q.offer(nx);
                    }
                }
                size--;
            }
            res++;
        }
        System.out.println(res);
    }
}
