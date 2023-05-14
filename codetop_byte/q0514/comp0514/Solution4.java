package codetop_byte.q0514.comp0514;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution4 {
    int[] fa;
    public int countCompleteComponents(int n, int[][] edges) {
        int[] degrees = new int[n];
        fa = new int[n];
        for(int i = 0; i < n; i++) {
            fa[i] = i;
        }
        for(int[] edge : edges) {
            int a = edge[0],b = edge[1];
            degrees[a]++;
            degrees[b]++;
        }
        for(int[] edge : edges) {
            int a = edge[0],b = edge[1];
            union(a,b);
        }
        for(int i = 0; i < n; i++) {
            find(i);
        }
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            if(fa[i] == i) {
                set.add(i);
            }
        }
       for(int f : set) {
           boolean isM = true;
           int cnt = 0;
           for(int i = 0;i < n; i++) {
               if(fa[i] == f) {
                   cnt++;
               }
           }
           cnt-=1;
           for(int i = 0; i < n; i++) {
               if(fa[i] == f) {
                   if(degrees[i] != cnt) {
                       isM = false;
                       break;
                   }
               }
           }
           if(isM) {
               res++;
           }
       }
       return res;

    }
    private int find(int x) {
        if(x != fa[x]) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }
    private void union(int a,int b) {
        fa[find(a)] = find(b);
    }
    @Test
    public void show() {
        int[][] edges = {{0,1},{0,2},{1,3},{3,2}};
        System.out.println(countCompleteComponents(4,edges));
    }
}
