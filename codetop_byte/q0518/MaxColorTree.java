package codetop_byte.q0518;

import java.util.*;

public class MaxColorTree {

    // f[i][0] 表示以i为根节点,不选该节点的边的最大值,f[i][1] 表示以i为根节点,选择该节点的边的最大值
    // f[i][0] = sum(f[child(i)][1])
    // f[i][1] = Math.max(wi+f[child(i)][0]+sum(f(child(j)][1])),j!=i
    static int[][] f;
    static int n;
    static List<int[]>[] edges;
    static boolean[] isV;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        edges = new List[n + 1];
        isV = new boolean[n + 1];
        f = new int[n + 1][2];
        for(int i = 1; i <= n; i++) {
            Arrays.fill(f[i],-1);
        }
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            edges[u].add(new int[]{v, w});
            edges[v].add(new int[]{u, w});
        }
        int res = Math.max(dfs(1,-1,0),dfs(1,-1,1));
        System.out.println(res);
    }

    private static int dfs(int index,int pre,int s) {
       if(f[index][s] != -1) {
           return f[index][s];
       }
       int notCho = 0;
       int cho = 0;
       for(int[] nxs : edges[index]) {
           if(nxs[0] == pre) {
               continue;
           }
           notCho += dfs(nxs[0],index,1);
       }
       if(s == 0) {
           f[index][s] = notCho;
           return notCho;
       }
       for(int i = 1; i <= edges[index].size(); i++) {
           int tmp = 0;
           for(int j = 1; j <= edges[index].size(); j++) {
               int v = edges[index].get(j)[0];
               int w = edges[index].get(j)[1];
               if(v == pre) {
                   continue;
               }
               if(j == i) {
                   tmp += w + dfs(v,index,0);
               }else{
                   tmp += dfs(v,index,1);
               }
           }
           cho = Math.max(cho,tmp);
       }
       f[index][s] = cho;
       return cho;
    }
}
