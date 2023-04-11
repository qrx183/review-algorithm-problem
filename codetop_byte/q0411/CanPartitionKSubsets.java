package codetop_byte.q0411;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CanPartitionKSubsets {
    boolean[] f;
    int avg;
    int n;
    int[] nums;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        if (k == 1) {
            return true;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        // 这里必须排序,否则在下面的遍历中可能会出现提前退出的现象
        Arrays.sort(nums);
        avg = sum / k;
        n = nums.length;
        f = new boolean[1<<n];
        Arrays.fill(f,true);
        return dfs((1<<n)-1,0);


    }
    private boolean dfs(int s,int num) {
        if (s == 0){
            return true;
        }
        if (! f[s]) {
            return f[s];
        }
        // f记录的是s状态下是否能满足均分成k份,如果s:(去除0,1)不能返回true,那s':(去除1,0)肯定也返回不了
        f[s] = false;
        for (int i = 0; i < n; i++) {
            if(num + nums[i] > avg) {
                break;
            }
            if (((s >> i) & 1) != 0) {
                // 从当前状态中去掉nums[i]后的状态
                if(dfs(s^(1<<i),(num+nums[i])%avg)){
                    return true;
                }
            }
        }
        return false;
    }
    @Test
    public void show() {
        int[] arr = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(canPartitionKSubsets(nums,4));
    }

}
