package codetop_byte.q0407;

import java.util.LinkedList;
import java.util.Queue;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 单调队列中应该存放index,这样才能确保头元素的有效性
        LinkedList<Integer> q = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n-k+1];
        int i = 0;

        while(i < n) {
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offerLast(i);
            if(q.peekFirst() <= i - k) {
                q.pollFirst();
            }
            if(i >= k-1) {
                res[i+1-k] = nums[q.peekFirst()];
            }
            i++;
        }
        return res;
    }
}
