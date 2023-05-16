package codetop_byte.q0515;

public class Trap {
    public int trap(int[] height) {
        // 计算每个点左右对应的最大高度
        int n = height.length;
        int[] lHeights = new int[n];
        int[] rHeights = new int[n];
        lHeights[0] = height[0];
        rHeights[n-1] = height[n-1];
        for(int i = 1; i < n; i++) {
            lHeights[i] = Math.max(lHeights[i-1],height[i]);
            rHeights[n-i-1] = Math.max(rHeights[n-i],height[n-i-1]);
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            res += Math.max(Math.min(lHeights[i],rHeights[i])-height[i],0);
        }
        return res;
    }
}
