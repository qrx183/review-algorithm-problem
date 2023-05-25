package codetop_byte.q0525.meituan;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][][] f = new int[n+1][x+1][y+1];
        int[] prices = new int[n+1];
        int[] xPrices = new int[n+1];
        for(int i = 1; i <= n; i++) {
            prices[i] = scanner.nextInt();
            xPrices[i] = scanner.nextInt();
        }
        int maxCnt = 0,moneyCnt = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= x; j++) {
                for(int k = y; k >= 0; k--) {
                    f[i][j][k] = Math.max(f[i-1][j][k],f[i][j][k]);
                    if(j-prices[i] >= 0) {
                        f[i][j][k] = Math.max(f[i-1][j-prices[i]][k]+1,f[i][j][k]);
                    }
                    if(j-xPrices[i] >= 0 && k != y) {
                        f[i][j][k] = Math.max(f[i][j][k],f[i-1][j-xPrices[i]][k+1]+1);
                    }
                    if(maxCnt < f[i][j][k]) {
                        maxCnt = f[i][j][k];
                        moneyCnt = j;
                    }else if(maxCnt == f[i][j][k]) {
                        moneyCnt = Math.min(moneyCnt,j);
                    }
                }
            }
        }
        System.out.println(maxCnt + " " + moneyCnt);
    }
}
