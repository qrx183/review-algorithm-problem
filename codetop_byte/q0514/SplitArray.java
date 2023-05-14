package codetop_byte.q0514;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class SplitArray {
    public int splitArray(int[] nums, int k) {
        int l = 0,r = Integer.MAX_VALUE;
        while(l < r) {
            int mid = l + (r-l)/2;
            // int mid = l + (r+1-l)/2;  l + r + 1 / 2;
            // 最大的值最小.
            // 求最小的值最大也是类似的形式,二分枚举mid,然后check(mid)要判断的是是否存在一种划分,使得每个子数组的和均大于等于mid
            if(check(nums,k,mid)) {
                r = mid;
                // l = mid;
            }else{
                l = mid + 1;
                // r = mid -1;
            }
        }
        return l;
    }
    private boolean check(int[] nums,int k,int sum) {
        int i = -1, n = nums.length;
        while(i + 1< n) {
            int cur = 0;
            while(i+1 < n && nums[i+1]+cur <= sum) {
                cur += nums[i+1];
                i++;
            }
            k--;
            if(k < 0) {
                return false;
            }
        }
        return k >= 0;
    }

}
