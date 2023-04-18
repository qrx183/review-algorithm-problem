package codetop_byte.q0418;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MaxProfit {
    public int maxProfit (int[] prices) {
        int m = prices.length;
        int[][] f = new int[m][5];
        // 这个初始化是必要的,因为第三笔交易和第四笔交易是不能在前两天完成的
        Arrays.fill(f[0],-10000);
        f[0][0] = 0;
        f[0][1] = -prices[0];
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0];
            f[i][1] = Math.max(f[i - 1][0] - prices[i], f[i - 1][1]);
            f[i][2] = Math.max(f[i - 1][1] + prices[i], f[i - 1][2]);
            f[i][3] = Math.max(f[i - 1][2] - prices[i], f[i - 1][3]);
            f[i][4] = Math.max(f[i - 1][3] + prices[i], f[i - 1][4]);
        }
        return Math.max(f[m-1][2],Math.max(f[m - 1][4], 0));

    }
    @Test
    public void show() {
        int[] arr = {8,9,3,5,1,3};
        System.out.println(maxProfit(arr));
    }
}
