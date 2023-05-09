package codetop_byte.q0509;

import java.util.*;

public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] ans = new int[numCourses];
        Map<Integer, List<Integer>> nxs = new HashMap<>();
        for(int[] dir : prerequisites) {
            inDegree[dir[0]]++;
            List<Integer> l = nxs.get(dir[1]);
            if(l == null) {
                l = new ArrayList<>();
            }
            l.add(dir[0]);
            nxs.put(dir[1],l);
        }
        int index = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i <numCourses; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()) {
            int cur = q.poll();
            ans[index++] = cur;
            if(nxs.get(cur) != null) {
                for(int nx : nxs.get(cur)) {
                    inDegree[nx] --;
                    if(inDegree[nx] == 0) {
                        q.offer(nx);
                    }
                }
            }

        }
        for(int degree : inDegree) {
            if(degree != 0){
                return new int[0];
            }
        }
        return ans;
    }
}
