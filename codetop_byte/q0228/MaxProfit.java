package codetop_byte.q0228;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        // 获取股票最大利润I
        int len = prices.length;
        if (len == 0 || len == 1) {
            return 0;
        }
        int sell = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++){
            if(prices[i] > sell){
                if (prices[i] - sell > maxProfit) {
                    maxProfit = prices[i] - sell;
                }
            }else{
                sell = prices[i];
            }
        }
        return maxProfit;
    }
}
