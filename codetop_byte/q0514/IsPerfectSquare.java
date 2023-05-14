package codetop_byte.q0514;

public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long l = 1, r = Integer.MAX_VALUE;
        while(l < r) {
            long m = l + r >> 1;
            if(m * m == num) {
                return true;
            }
            if(m * m > num) {
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return l * l == num;
    }
}
