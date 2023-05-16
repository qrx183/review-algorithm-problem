package codetop_byte.q0515;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n+1-k];
        Deque<Integer> d = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            while(!d.isEmpty() && nums[i] >= nums[d.peekLast()]) {
                d.pollLast();
            }

            d.offer(i);
            if(i+1-k > d.peekFirst()) {
                d.pollFirst();
            }
            if(i >= k-1) {
                res[i+1-k] = nums[d.peekFirst()];
            }

        }
        return res;
    }
}
