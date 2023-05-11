package codetop_byte.q0511;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        int n = coins.length;
        boolean[] isV = new boolean[amount+1];
        isV[0] = true;
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int node = arr[0];
            int cnt = arr[1];

            if(node == amount) {
                return cnt;
            }
            for(int i = 0; i < n; i++) {
                if(amount-node < coins[i] || isV[node+coins[i]]) {
                    continue;
                }
                // 这个判断能够剪去很多分支,是常见的一种最短路的优化方式:剪枝
                isV[node+coins[i]] = true;
                q.offer(new int[]{node+coins[i],cnt+1});
            }
        }
        return -1;
    }
    @Test
    public void show() {
        System.out.println(coinChange(new int[]{1,2,5},11));
    }
}
