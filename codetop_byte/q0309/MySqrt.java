package codetop_byte.q0309;

public class MySqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int ans = (int)(Math.exp(0.5*Math.log(x)));
        return (long)(ans+1)*(ans+1) <= x ? ans+1 : ans;
    }
}
