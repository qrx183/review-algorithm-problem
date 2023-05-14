package codetop_byte.q0514;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        int l = 0,r = nums.length-1;
        while(l < r) {
            int mid = l + r >> 1;
            if(nums[mid] >= target) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        if(nums[l] != target) {
            return new int[]{-1,-1};
        }
        int ans1 = l;
        l = 0;
        r = nums.length-1;
        while(l < r) {
            int mid = l + r + 1 >> 1;
            if(nums[mid] <= target) {
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        int ans2 = l;
        return new int[]{ans1,ans2};
    }
}
