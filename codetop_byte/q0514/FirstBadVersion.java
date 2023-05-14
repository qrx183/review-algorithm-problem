package codetop_byte.q0514;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        long l = 1,r = n;
        while(l < r) {
            long mid = l + r >> 1;
            if(isBadVersion((int)mid)) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return (int)l;
    }
    private boolean isBadVersion(int index) {
        // 题目本身提供的方法
        return true;
    }
}
