package codetop_byte.q0517;

import java.util.*;

public class ColorTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] degrees = new int[n+1];
        int[] blueCnt = new int[n+1];
        boolean[] isV = new boolean[n+1];
        List<Integer>[] nxs = new List[n+1];
        for(int i = 1; i <= n; i++) {
            nxs[i] = new ArrayList<>();
        }
        for(int i = 0; i < n-1; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            nxs[a].add(b);
            nxs[b].add(a);
            degrees[a]++;
            degrees[b]++;

        }
        Queue<Integer> q = new LinkedList<>();
        char[] res = new char[n];
        Arrays.fill(res,'0');
        for(int i = 1; i <= n; i++) {
           if(degrees[i] == 1) {
               q.offer(i);
               blueCnt[i]++;
               isV[i] = true;
               res[i-1] = 'B';
           }
        }

        degrees[1]++;
        while(!q.isEmpty()) {
            int node = q.poll();
            if(blueCnt[node] % 2 == 0 && res[node-1] == '0') {
                blueCnt[node]++;
                res[node-1] = 'B';
            }else if(res[node-1] == '0'){
                res[node-1] = 'R';
            }
            for(int nx : nxs[node]) {
                if(!isV[nx]) {
                    degrees[nx]--;
                    blueCnt[nx] += blueCnt[node];
                    if(degrees[nx] == 1) {
                        q.offer(nx);
                        isV[nx] = true;
                    }
                }
            }
        }


        System.out.println(new String(res));

    }
}
