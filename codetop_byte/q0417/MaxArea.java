package codetop_byte.q0417;

public class MaxArea {
    public int maxArea (int[] height) {

        int m = height.length;
        if(m < 2) {
            return 0;
        }
        int l = 0,r = m-1;
        int res = 0;
        while(l < r) {
            res = Math.max(res,Math.min(height[l],height[r])*(r-l));
            if (height[l] < height[r]) {
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
