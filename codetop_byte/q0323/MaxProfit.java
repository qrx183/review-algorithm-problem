package codetop_byte.q0323;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int m = prices.length;
        int[][] profit = new int[m][2];
        // f[i][0]表示第i天买股票的最大利润,f[i][1]表示第i天卖股票的最大利润
        profit[0][0] = -prices[0];
        profit[0][1] = 0;
        for(int i = 1; i < m; i++) {
            profit[i][1] = Math.max(profit[i-1][0]+prices[i],profit[i-1][1]);
            profit[i][0] = Math.max(profit[i-1][1]-prices[i],profit[i-1][0]);
        }
        return Math.max(profit[m-1][0],profit[m-1][1]);
    }
}
