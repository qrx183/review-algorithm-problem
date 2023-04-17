package codetop_byte.q0416;

import org.junit.jupiter.api.Test;

public class CountDigitOne {
    // f[i] 表示[0,10^i)中包含的所有1的个数
    static int[] f = new int[10];
    static {
        f[0] = 0;
        f[1] = 1;
        for(int i = 2; i < 10; i++) {
            f[i] = f[i-1] + 9*f[i-1]+(int)Math.pow(10,i-1);
        }
    }
    public int countDigitOne(int n) {
        int k = getKth(n);
        int res = 0;
        while(k >= 0) {
            // 对于一个 xyzm的值,找0-x000,0-y00,0-z0,0-m中1的个数.同时如果xyzm中某个位为1,则还需要考虑有多少个数字中的这个位为1:假设y为1,则要多考虑zm个1
            // 本质其实是在遍历0-z0时,考虑的其实xy00-xyz0
            int m = n / (int)Math.pow(10,k) % 10;
            int r = n % (int)Math.pow(10,k);
            if(k == 0) {
                res += m == 0 ? 0 : 1;
                k--;
                continue;
            }
            res += getOneFromN(k,m) + (m == 1 ? r:0);
            k--;
        }
        return res;
    }
    private int getOneFromN(int k,int n) {
        // 计算0-n中1的个数 n是一个x0000的形式
        // x0000 = 0-9999 + 10000-(x-1)9999 + x0000
        int t = n * (int)Math.pow(10,k);
        int res = 0;
        res += f[k];
        res += (n <= 1 ? 0 : (int)Math.pow(10,k)) + (n-1)*f[k] + (n == 1 ? 1 : 0);
        return res;

    }
    private int getKth(int n) {
        int ans = 0;
        while(n >= 10) {
            ans++;
            n/=10;
        }
        return ans;
    }
    @Test
    public void show() {
        System.out.println(countDigitOne(238));
    }

}
