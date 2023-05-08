import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final int MOD = (int)(1e9+7);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long ans = 0;
        int n = scanner.nextInt();
        int[] f = new int[n];
        for(int i = 0; i < n; i++) {
            f[i] = scanner.nextInt();
        }
        long[] dp = new long[n];
        Arrays.sort(f);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(f[i] % f[j] == 0) {
                    dp[i] += dp[j]+1;
                    dp[i] = dp[i] % MOD;
                }
            }
            ans += dp[i];
            ans = ans % MOD;
        }
        System.out.println(ans % MOD);
    }
}
