package codetop_byte.q0606;

import java.util.Scanner;

public class SwapPears {
    private static final int MOD = (int)(1e9+7);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ss = new int[n];
        int[] ts = new int[n];
        long res = 1;
        for(int i = 0; i < n; i++) {
            ss[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++){
            ts[i] = scanner.nextInt();
            res = res * ts[i];
            res %= MOD;
        }
        for(int i = 0; i < n-1; i++) {
            if(ss[i] / (ts[i]*1.0) > ss[i+1]/(ts[i+1]*1.0)) {
                res = res / ts[i] * ss[i];
            }else{
                res = res / ts[i+1] * ss[i+1];
            }
            res = res % MOD;
        }
        System.out.println(res);
    }
}
