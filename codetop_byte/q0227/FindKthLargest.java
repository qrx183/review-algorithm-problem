package codetop_byte.q0227;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class FindKthLargest {
    @Test

    public void test() {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums,2));
    }
    Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        // 寻找数组的第k大个数， O n 时间复杂度， 利用的是快排的思想
        // 快排每次可以确定数组中某个数的位置 基于此， 我们可以通过快排来获取第n-k个数的位置
        // 但快排的时间复杂度为o logn 所以通过随机化初始因子来降低时间复杂度。 证明过程可能需要看一下
        return quickSort(nums,0,nums.length-1, nums.length - k);
    }

    public int quickSort(int[] nums, int l, int r, int index) {
        int i = getRandomPart(nums,l,r);
        if (i == index) {
            return nums[i];
        }
        return i < index ? quickSort(nums,i+1,r,index) :quickSort(nums,l,i-1,index);
    }

    public int getRandomPart(int[] nums, int l, int r) {
        int index = random.nextInt(r-l+1) + l;
        swap(nums,l,index);
        return partion(nums,l,r);
    }

    public int partion(int[] nums, int l, int r) {
        int key = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= key) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= key) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = key;
        return l;
    }

    public void swap(int[] nums,int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
