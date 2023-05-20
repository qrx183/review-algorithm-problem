package codetop_byte.q0520;

import java.util.Scanner;

public class CandyFeast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        // f[i][j][x] 表示第i天在还剩下k次打破次数的条件下吃/不吃的最大价值
        // f[i][0][k] = f[i-1][1][k]
        // f[i][1][k] = max(f[i-1][0][k],f[i-1][1][k+1])+a[i]
        int[][][] f = new int[n][2][k+1];
        f[0][1][k] = a[0];
        for(int i = 1; i < n; i++) {
            for(int j = k; j >= 0; j--) {
                f[i][0][j] = f[i-1][1][j];
                if(j == k) {
                    f[i][1][j] = f[i-1][0][j]+a[i];
                }else{
                    f[i][1][j] = Math.max(f[i-1][0][j],f[i-1][1][j+1])+a[i];
                }
            }
        }
        int res = 0;
        for(int i = 0; i <= k; i++) {
            res = Math.max(res,Math.max(f[n-1][0][i],f[n-1][1][i]));
        }
        System.out.println(res);
    }
}
