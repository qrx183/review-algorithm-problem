package codetop_byte.q0409;

public class Rob {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }else if (n == 2) {
            return Math.max(nums[0],nums[1]);
        }
        int[] f = new int[n];
        f[0] = nums[0];
        f[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < n; i++) {
            f[i] = Math.max(f[i-1],f[i-2]+nums[i]);
        }
        return f[n-1];
    }
}
