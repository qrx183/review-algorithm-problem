package codetop_byte.q0304;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int target = 0;
        int n = nums.length;
        if (n == 0) {
            return target;
        }
        int[] f = new int[n];
        f[0] = nums[0];
        target = nums[0];
        for(int i = 1; i < n; i++) {
            if(f[i-1] < 0){
                f[i] = nums[i];
            }else{
                f[i] = nums[i] + f[i-1];
            }
            target = Math.max(target,f[i]);
        }
        return target;
    }
}
