package codetop_byte.q0323;

import java.util.LinkedList;
import java.util.Queue;

public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n <= 0){
            return 0;
        }
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int num : nums) {
            q.offer(num);
            sum += num;
            while (sum >= target) {
                res = Math.min(res, q.size());
                sum-=q.poll();
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
