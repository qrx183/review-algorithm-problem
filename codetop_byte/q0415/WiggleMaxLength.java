package codetop_byte.q0415;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return n;
        }
        if (n == 2) {
            return nums[0] == nums[1] ? 1 : 2;
        }
        int res = 1;
        int[] f = new int[n];
        int[] p = new int[n];
        Arrays.fill(f,1);
        f[0] = 1;
        p[1] = nums[1]-nums[0];
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(j == 0) {
                    if(nums[i]-nums[j] != 0) {
                        f[i] = 2;
                        res = Math.max(res,2);
                        p[i] = nums[i]-nums[j];
                    }
                    continue;
                }
                if(f[i] < f[j]+1) {
                    if((nums[i]-nums[j])*p[j]<0) {
                        f[i] = f[j]+1;
                        res = Math.max(res,f[i]);
                        p[i] = nums[i]-nums[j];
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void show() {
        int[] arr = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(arr));
    }
}
