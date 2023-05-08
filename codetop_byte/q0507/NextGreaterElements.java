package codetop_byte.q0507;

import java.util.Arrays;

public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        Arrays.fill(f,-1);
        for(int i = 0; i < n; i++) {
            for(int j = (i + 1)%n; j != i; j = (j+1)%n) {
                if(nums[j] > nums[i]){
                    f[i] = nums[j];
                    break;
                }
            }
        }
        return f;
    }
}
