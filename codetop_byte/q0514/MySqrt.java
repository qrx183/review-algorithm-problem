package codetop_byte.q0514;

public class MySqrt {
    public int mySqrt(int x) {
        long l = 0,r = Integer.MAX_VALUE-1;
        while(l < r) {
            long mid = l + r + 1 >> 1;
            if(mid * mid <= x) {
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return (int)l;
    }
}
