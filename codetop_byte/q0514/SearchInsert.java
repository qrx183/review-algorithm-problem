package codetop_byte.q0514;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l < r) {
            int mid = l + r >> 1;
            if(nums[mid] >= target) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return nums[l] >= target ? l : l + 1;
    }
}
