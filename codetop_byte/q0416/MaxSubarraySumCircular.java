package codetop_byte.q0416;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MaxSubarraySumCircular {
    /*
        环形最大子数组和
        1.中间部分最大(不涉及首尾循环):正常的最大子数组和求法
        2.首尾循环最大,那么说明中间部分最小,正常的最小子数组和,然后用数组和-最小子数组和
     */
    public int maxSubarraySumCircular(int[] nums) {
        int dp = nums[0],max = dp, sum = dp,min = 0;
        for(int i = 1; i < nums.length; i++){
            sum += nums[i];
            dp = nums[i] + Math.max(dp, 0);
            max = Math.max(dp, max);
        }
        dp = nums[0];
        // 这里 i < nums.length-1 的原因是 兼顾到数组全是负数的情况造成sum-min=0的情况  同时因为这里求取的前提是在数组的中间部分算最小数组和,所以
        // 不需要担心不遍历最后一个值造成的影响
        // 当然也可以单独将数组全为负数拿出来考虑一下
        for(int i = 1; i < nums.length -1; i++){
            dp = nums[i] + Math.min(0,dp);
            min = Math.min(dp,min);
        }
        return Math.max(sum-min,max);
    }
    @Test
    public void show() {
        int [] arr = {-4,-3,-2};
        System.out.println(maxSubarraySumCircular(arr));
    }
}
