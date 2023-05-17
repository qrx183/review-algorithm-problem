package codetop_byte.q0517;

import java.util.Scanner;

public class CombinationLock {
    private static final int MOD = (int)(1e9+7);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] f = new int[n];
        for(int i = 0; i < n; i++) {
            f[i] = scanner.nextInt();
        }
        // cnt[i][j] 表示前i个字符,第i个字符为j时的个数
        // cnt[i][j] = cnt[i-1][j-A[i]] + cnt[i-1][j+A[i]]
        long[][] cnt = new long[n][26];
        cnt[0][f[0]] = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 26; j++) {
                int ch1 = j+f[i];
                int ch2 = j-f[i];
                if(0<=ch1 && ch1<=25){
                    cnt[i][j] += cnt[i-1][ch1];
                    cnt[i][j] = cnt[i][j] % MOD;
                }
                if(0<=ch2 && ch2<=25){
                    cnt[i][j] += cnt[i-1][ch2];
                    cnt[i][j] = cnt[i][j] % MOD;
                }
            }
        }
        long res = 0;
        for(long count : cnt[n-1]) {
            res += count;
            res = res % MOD;
        }
        System.out.println(res);


    }

}
