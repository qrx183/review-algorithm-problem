package codetop_byte.q0511;

import java.util.LinkedList;
import java.util.Queue;

public class Jump {
    public int jump(int[] nums) {
        int n = nums.length;
        boolean[] isV = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        isV[0] = true;
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int index = arr[0];
            int step = arr[1];
            if(index == n-1) {
                return step;
            }
            for(int i = 1; i <= nums[index]; i++) {
                if(index+i > n-1 || isV[index+i]) {
                    continue;
                }
                isV[index+i] = true;
                q.offer(new int[]{index+i,step+1});
            }
        }
        return -1;
    }
}
