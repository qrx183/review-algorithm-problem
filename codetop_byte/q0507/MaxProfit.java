package codetop_byte.q0507;

import org.junit.jupiter.api.Test;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // f[i][0]:第一次售卖的利润,f[i][1]:第一次卖出的利润
        // f[i][1]:第二次售卖的利润,f[i][3]:第二次卖出的利润
        long[][] f = new long[n][4];
        f[0][0] = -prices[0];
        f[0][1] = Integer.MIN_VALUE;
        f[0][2] = Integer.MIN_VALUE;
        f[0][3] = Integer.MIN_VALUE;

        for(int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i-1][0],-prices[i]);
            f[i][1] = Math.max(f[i-1][1],f[i-1][0]+prices[i]);
            f[i][2] = Math.max(f[i-1][2],f[i-1][1]-prices[i]);
            f[i][3] = Math.max(f[i-1][3],f[i-1][2]+prices[i]);
        }
        return Math.max(Math.max((int)f[n-1][1],(int)f[n-1][3]),0);
    }
    @Test
    public void show() {
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }
}
