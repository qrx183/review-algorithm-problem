package codetop_byte.q0611;

import org.junit.jupiter.api.Test;
public class MinCost {
    public long minCost(int[] nums, int x) {
        // 对于很复杂的贪心，其实可以考虑用dp来描述求解
        int n = nums.length;
        int[][] f = new int[n][n];
        // f[i][j] 第i个物品在j次操作下的最小代价
        for(int i = 0; i < n; i++) {
            f[i][0] = nums[i];
        }
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < n;j++) {
                f[i][j] = Math.min(f[i][j-1],nums[(i-j+n)%n]);
            }
        }
        long res = Long.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            long cur = 0;
            for(int j = 0; j < n; j++) {
                cur += f[j][i];
            }
            res = Math.min(res,cur + (long) i * x);
        }
        return res;
    }
    @Test
    public void show() {
        int[] arr = {15,150,56,69,214,203};
        System.out.println(minCost(arr,42));
    }
}
