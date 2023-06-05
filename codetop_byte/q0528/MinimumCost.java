package codetop_byte.q0528;

public class MinimumCost {
    public long minimumCost(String s) {
        // 这道题其实好好想想能做出来(上午状态太差了,下午来library的路上想出来了...)
        // 就是一个贪心的思想:每一次都把前面的值和后一位做比较,如果相同不需要翻转,如果不同则翻转左右成本低的
        // 保证遍历到i时i之前的数全是相同的
        int n = s.length();
        int i = 0;
        long res = 0;
        while(i < n) {
            while(i+1 < n && s.charAt(i) == s.charAt(i+1)) {
                i++;
            }
            res += Math.min(i+1,n-i-1);
            i++;
        }
        return res;
    }
}
