package codetop_byte.q0316;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CoinChange {
    // dp:无线dp? 忘记叫啥了...
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        if (amount == 0) {
            return 0;
        }
        if (m == 0) {
            return -1;
        }
        int[] f = new int[amount+1];
        Arrays.fill(f,Integer.MAX_VALUE);
        f[0] = 0;
        for (int i = 1; i <= m; i++) {
            for(int j = coins[i-1]; j <= amount; j ++) {
                if (f[j-coins[i-1]] != Integer.MAX_VALUE) {
                    f[j] = Math.min(f[j],f[j-coins[i-1]]+1);
                }
            }
        }
        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }
    @Test
    public void show (){
        int[] arr = new int[]{1,2,5};
        System.out.println(coinChange(arr,11));
    }

}
