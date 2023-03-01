package codetop_byte.q0301;

import org.junit.jupiter.api.Test;

public class Search {
    /*
        search1是正解, search是比较繁琐的解法
     */
    public int search1(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        int l = 0, r = len-1;

        while(l < r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if(nums[0] < nums[mid]){
                if (nums[0] <= target && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if (nums[mid] < target && target <= nums[len-1]) {
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return nums[l] == target ? l : -1;
    }

    public int search(int[] nums, int target){
        int len = nums.length;
        if(len == 0) {
            return -1;
        }
        int l = 0,r = len-1;
        while(l < r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < nums[len-1]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        int lRes = binarySearch(nums,0,l-1,target);
        int rRes = binarySearch(nums,l,len-1,target);
        if (lRes != -1) {
            return lRes;
        }else if (rRes != -1) {
            return rRes;
        }else{
            return -1;
        }
    }
    public int binarySearch(int[] nums,int l,int r,int target) {
        while(l < r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }
    @Test
    public void test(){
        int[] nums = {4,5,6,7,8,1,2,3};
        System.out.println(
                search(nums,8)
        );
    }
}
