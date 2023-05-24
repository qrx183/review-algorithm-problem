package codetop_byte.q0523;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MultipleSubSet {
    private static final int MOD = (int)(1e9+7);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        long res = 0;
        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        // f[i] 表示所有子集中最大值为i的子集的数量.
        // 那么f[i] = sum(f[j]),j是i的因子
        long[] f = new long[1001];
        f[a[0]] = 1;
        res += 1;
        for(int i = 1; i < n; i++) {
            List<Integer> factors = getFactors(a[i]);
            for(int factor : factors) {
                if(factor != a[i]) {
                    f[a[i]] += f[factor];
                }else{
                    f[a[i]] += 1;
                }
            }
            res = (res + f[a[i]]) % MOD;
        }
        System.out.println(res-n);
    }
    private static List<Integer> getFactors(int a) {
        int i = 1;
        List<Integer> res = new ArrayList<>();
        while(i*i<=a) {
            if(a % i == 0) {
                res.add(i);
                if(a / i != i) {
                    res.add(a/i);
                }
            }
            i++;
        }
        return res;
    }
}
