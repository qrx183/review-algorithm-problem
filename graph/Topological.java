package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Topological {

    /*
        拓扑排序:a->b 则拓扑排序中a一定位于b之前
        拓扑排序可以同来判断图是否有环
     */
    Queue<Integer> q = new LinkedList<>();
    int[] inDegree;
    int[][] dir;
    public void topological(int[][] dir) {
        this.dir = dir;
        int n = dir.length;
        inDegree = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < dir[i].length;j++) {
                inDegree[dir[i][j]] ++;
            }
        }
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()) {
            int curNode = q.poll();
            System.out.println(curNode);

            for(int nx : dir[curNode]) {
                inDegree[nx]--;
                if(inDegree[nx] == 0) {
                    q.offer(nx);
                }
            }
        }
    }
}
