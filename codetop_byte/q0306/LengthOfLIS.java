package codetop_byte.q0306;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        // 最长递增子序列
        /*
            1. 动态规划 f[i] = max(nums[k] < nums[i] ? f[k]+1) k = 0..i-1
            2. 贪心+二分
                每次二分都是找第一个比nums[i]小的数list[k],将list[k+1]设为nums[i],如果没有比nums[i]小的数,就将list[k]设置为nums[i]
                技巧是从1-n+1,而不是从0-n

                其实也而可以每次找第一个比nums[i]大(大于等于)的数
         */
        int n = nums.length;
        int size = 0;
        if (n <= 0) {
            return size;
        }
        int[] list = new int[n+1];
        list[1] = nums[0];
        size = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > list[size]) {
                list[++size] = nums[i];
            }else {
                int l = 1, r = size;
                while(l < r) {
                    int mid = l + r + 1 >> 1;
                    if (list[mid] >= nums[i]) {
                        r = mid - 1;
                    }else {
                        l = mid;
                    }
                }
                if (list[l] < nums[i]) {
                    list[l+1] = nums[i];
                }else {
                    list[l] = nums[i];
                }
            }
        }
        return size;
    }
    @Test
    public void show(){
        int[] nums = {10,9,2,5,3,7,101,18};

        System.out.println(lengthOfLIS(nums));
    }
}
