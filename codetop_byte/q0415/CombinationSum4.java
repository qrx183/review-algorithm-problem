package codetop_byte.q0415;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        // 这个不同于一般意义上的多重背包,需要考虑到排列组合
        // f[i][j] += sum[f[i][j-nums[k]] (k --[0,i])
        // 这里可以用一维滚动的形式减少时间复杂度到O(n):f[j] = f[j-nums[i-1]]. 这里的滚动非常有意思,竟然能减少时间复杂度,厉害厉害
       int[] f = new int[target+1];
       f[0] = 1;
       for(int i = 1; i <= target; i++) {
           for(int j = 1; j <= nums.length; j++) {
               if(i - nums[j-1] >= 0) {
                   f[i] += f[i-nums[i-1]];
               }
           }
       }
       return f[target];
    }

    @Test
    public void show() {
        int[] arr = {1,2,3};
        System.out.println(combinationSum4(arr,4));
    }

}
