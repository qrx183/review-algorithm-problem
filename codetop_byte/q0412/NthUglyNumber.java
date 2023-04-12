package codetop_byte.q0412;

public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        if (n <= 3) {
            return n;
        }
        int[] f = new int[n+1];
        f[1] = 1;
        int p2 = 1,p3 = 1,p5 = 1;
        for(int i = 2; i <= n; i++) {
            int num = Math.min(Math.min(f[p2]*2,f[p3]*3),f[p5]*5);
            f[i] = num;
            if (f[i] == f[p2]*2) {
                p2++;
            }
            if(f[i] == f[p3]*3) {
                p3++;
            }
            if(f[i] == f[p5]*5) {
                p5++;
            }
        }
        return f[n];
    }
}
