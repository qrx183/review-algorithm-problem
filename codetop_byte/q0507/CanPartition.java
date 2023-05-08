package codetop_byte.q0507;

public class CanPartition {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        // f[i][j] 表示前i个值能否装满j容量
        int c = sum/2;
        boolean[][] f = new boolean[n+1][c+1];

        f[0][0] = true;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= c; j++) {
                f[i][j] = f[i-1][j];
                if(j-nums[i-1]>=0) {
                    f[i][j] = f[i][j] ||  f[i-1][j-nums[i-1]];
                }

            }
        }
        return f[n][c];
    }
}
