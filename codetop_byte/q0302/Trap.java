package codetop_byte.q0302;

public class Trap {
    public int trap(int[] height) {
        int n = height.length;
        int[] lMax = new int[n];
        int[] rMax = new int[n];
        lMax[0] = height[0];
        rMax[n-1] = height[n-1];
        for(int i = 1; i < n; i++) {
            lMax[i] = Math.max(lMax[i-1],height[i]);
            rMax[n-i-1] = Math.max(rMax[n-i],height[n-i-1]);
        }

        int res = 0;
        for(int i = 0; i < n; i++){
            res += Math.min(lMax[i],rMax[i])-height[i];
        }
        return res;
    }
}
