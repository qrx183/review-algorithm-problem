package codetop_byte.q0518;

import java.util.*;

public class MeituanValue {
    static int[] c;
    static int[] V;
    static  List<Integer>[] edges;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        edges = new List[n+1];
        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for(int i = 1; i <= n-1; i++) {
            int u = scanner.nextInt();
            edges[u].add(i);
        }
        c = new int[n+1];
        V = new int[n+1];
        for(int i = 1; i <= n; i++) {
            c[i] = scanner.nextInt();
        }
        dfs(1,0);
        System.out.println(V[1]);
    }
    private static int dfs(int node,int pre) {
        if(node != 1 && edges[node].size() <= 1) {
            return 1;
        }
        for(int nx : edges[node]) {
            if(nx == pre) {
                continue;
            }
            if(c[node] == 1){
                V[node] += dfs(nx,node);
            }else{
                V[node] ^= dfs(nx,node);
            }
        }
        return V[node];
    }
}
