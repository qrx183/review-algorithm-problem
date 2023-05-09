package codetop_byte.q0509;

import org.junit.jupiter.api.Test;

import java.util.*;

public class EventualSafeNodes {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       List<List<Integer>> rg = new ArrayList<>();
       int n = graph.length;
       for(int i = 0; i < n; i++) {
           rg.add(new ArrayList<>());
       }
       for(int i = 0; i < n; i++) {
           for(int nx:graph[i]) {
               rg.get(nx).add(i);
           }
       }
       int[] inDegree = new int[n];
       for(int i = 0; i < n; i++) {
           for(int nx : rg.get(i)) {
               inDegree[nx]++;
           }
       }
       Queue<Integer> q = new LinkedList<>();
       for(int i = 0; i < n; i++) {
           if(inDegree[i] == 0) {
               q.offer(i);
           }
       }
       while(!q.isEmpty()) {
           int cur = q.poll();
           for(int nx : rg.get(cur)) {
               inDegree[nx]--;
               if(inDegree[nx] == 0) {
                   q.offer(nx);
               }
           }
       }
       List<Integer> res = new ArrayList<>();
       for(int i = 0; i < n; i++) {
           if(inDegree[i] == 0) {
               res.add(i);
           }
       }
       return res;
    }
    @Test
    public void show() {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph));
    }
}
