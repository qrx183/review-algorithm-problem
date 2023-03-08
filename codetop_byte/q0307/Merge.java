package codetop_byte.q0307;

import org.junit.jupiter.api.Test;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m+n];
        int i = 0,j = 0;
        int k = 0;
        while(i != m && j != n) {
            if(nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            }else{
                nums[k++] = nums2[j++];
            }
        }
        while(i != m) {
            nums[k++] = nums1[i++];
        }
        while(j != n) {
            nums[k++] = nums2[j++];
        }
        i = 0;
        for(; i < nums.length; i++) {
            nums1[i] = nums[i];
        }

    }
    @Test
    public void show() {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,3,nums2,3);
        System.out.println("");
    }
}
