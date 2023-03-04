package codetop_byte.q0304;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation1(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int r = n - 1;
        while(r > 0 && nums[r-1] >= nums[r]) {
            r--;
        }
        if (r > 0) {
            int key = nums[r-1];
            int tempR = n - 1;
            while(tempR >= 0 && nums[tempR] <= key) {
                tempR--;
            }
            int temp = nums[r-1];
            nums[r-1] = nums[tempR];
            nums[tempR] = temp;
        }

        int left = r;
        int right = n-1;
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    @Test
    public void show(){
        int[] nums = {1,3,2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
