package codetop_byte.q0514;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1 || nums[0] > nums[1]) {
            return 0;
        }
        if(nums[n-1] > nums[n-2]) {
            return n-1;
        }
        int l = 1, r = n-2;
        while(l < r) {
            long m = l + r >> 1;
            int mid = (int)m;
            // 其实一共有4种情况:峰值,谷值,上升,下降
            // 1. 峰值直接返回即可
            // 2. 上升和下降,由于题目说明两个边界都是-00,所以中间值一定是峰值,所以向中间靠拢即可
            // 3. 存在谷值就意味着左右两边一定至少都存在一个峰值,因为两个边界都是-00

            // 根据设置两个边界为-00从而将3种情况划分为2种,从而具备二段性
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            if(nums[mid] > nums[mid+1] && nums[mid] < nums[mid-1]) {
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}
