package codetop_byte.q0610;

import java.util.Scanner;

public class NNTakeSteps {
    private static final int MOD = (int) (1e9 + 7);
    private static int n;
    private static int m;
    private static long res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        //f[i][j][k] 表示 到达第i阶的前一步为i,再前1步为j的步数
        // f[i][j][k] += f[i-j][k][x]
        // 没想清楚，刚开始用了个二维数组，而且初始化也没初始化好，对于比较复杂的动态规划而言，应该尽可能的把能初始化的全部初始化掉，省的费事
        // 但确实这种题应该想到用记忆化搜索更形象的。。。
        long[][][] f = new long[n + 1][m + 1][m + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                if (i != j && i + j <= n) {
                    f[i + j][i][j] = 1;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int x = 1; x <= m; x++) {
                    if (x == j) {
                        continue;
                    }
                    for (int y = 1; y <= m; y++) {
                        if (i >= j && y != x && y != j) {
                            f[i][j][x] += f[i - j][x][y];
                            f[i][j][x] %= MOD;
                        }
                    }
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                res += f[n][i][j];
                res = res % MOD;
            }
        }
        System.out.println(res);
    }
}