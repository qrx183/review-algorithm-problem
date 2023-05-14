package codetop_byte.q0514;

public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        long l = 1, r = (long) 1e13;
        while (l < r) {
            long mid = l + r >> 1;
            if (check(piles, h, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    private boolean check(int[] piles, int h, long k) {
        int cnt = 0;
        for (int pile : piles) {
            if (pile % k == 0) {
                cnt += pile / k;
            } else {
                cnt += pile / k + 1;
            }
        }
        return cnt <= h;
    }
}
