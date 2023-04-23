package codetop_byte.q0423;

public class NumsOfGoodMatrix {

    // x为偶数===> 奇数和偶数的个数分别为x/2
    // 对于第一列,每个位置都可以放x种,所以A = x^n
    // 对于确定的一列,再添加一列保证仍未好矩阵的情况: 这种很容易证明,前一列好矩阵的排列可以分为三种:0个奇数(2个偶数),1个奇数(1奇1偶),2个奇数(0个偶数)
    // 对于每种情况,后一列的2个数要想和前一列的2个数生成"好矩阵",就需要凑成偶数个 奇数. 0 ---> 0 or 2,2 ---> 2 or 0, 1 --> 1 or 1
    //      1.该列的每个位置与前一列对应位置的奇偶性完全相反:(x/2)^n
    //      2.该列的每个位置与前一列对应位置的奇偶性完全相同:(x/2)^n
    // 排除第一列,一共m-1列,所以B = (2*(x/2)^n)^(m-1)
    // 所以A*B = (x/2)^(mn) * 2^(m+n-1)
    // a = x^n,b = 2*(x/2)^n  a*b^m-1 = x^(mn)*(1/2)^(mn-n+1-m) = (x/2)^(mn)*2^(m+n-1)

    // 注意:这里涉及到a^b 对 p 取模的问题,要用快乘的思想去取模,否则会溢出
    private static final int MOD = (int)1e9+7;
    public int numsOfGoodMatrix (int n, int m, int x) {
        long a = x / 2;
        long b = (long) m * n;
        long res = func(a,b);
        long resTmp = func(2,m+n-1);
        return(int) ((res * resTmp) % MOD);
    }

    private long func(long a,long b) {
        long res = 1;
        while(b != 0) {
            if((b & 1) != 0) {
                res = (res * a) %MOD;
            }
            a = (a*a)%MOD;
            b >>= 1;
        }
        return res % MOD;
    }
}
