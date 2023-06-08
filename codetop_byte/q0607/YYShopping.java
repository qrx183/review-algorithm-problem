package codetop_byte.q0607;

import java.util.Scanner;

public class YYShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] prices = new int[n];
        int[] good = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++) {
            good[i] = scanner.nextInt();
        }
        // f[i][j][0]:不买第i件产品
        // f[i][j][1]: 半价买第i件产品
        // f[i][j][2]: 全价买第i件产品
        int[][][] f = new int[n+1][x+1][3];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= x; j++) {
                f[i][j][0] = Math.max(f[i-1][j][0],Math.max(f[i-1][j][1],f[i-1][j][2]));
                if(j-prices[i-1]/2>=0) {
                    f[i][j][1] = f[i-1][j-prices[i-1]/2][2]+good[i-1];
                }
                if(j-prices[i-1]>=0) {
                    f[i][j][2] = Math.max(f[i-1][j-prices[i-1]][0],Math.max(f[i-1][j-prices[i-1]][1],f[i-1][j-prices[i-1]][2])) + good[i-1];
                }
            }
        }
        System.out.println(Math.max(f[n][x][0],Math.max(f[n][x][1],f[n][x][2])));

    }
}
