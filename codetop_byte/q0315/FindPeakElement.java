package codetop_byte.q0315;

import org.junit.jupiter.api.Test;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        // 假设nums[-1] = -oo and nums[n] = +oo 说明这个数组组成的函数再开始上升,再最后下降
        // 这也就意味着当nums[i] <= nums[i+1]时,[i+1:n-1]区间一定有峰值
        // 同理当nums[i] <= nums[i-1]时 [0:i-1]一定有峰值
        // 基于此形成了二段性,因此可以用二分
        int n = nums.length;
        if (n <= 1){
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n-1] > nums[n-2]) {
            return n-1;
        }
        int l = 0,r = n-1;
        while (l < r) {
            int mid = l + r >> 1;
            if ((mid == 0 || mid > 0 && nums[mid] > nums[mid-1]) && (mid + 1 == n || mid < n-1 && nums[mid] > nums[mid+1])) {
                return mid;
            }else if ((mid == 0 || mid > 0 && nums[mid] > nums[mid-1]) && (mid + 1 < n && nums[mid] <= nums[mid+1])) {
                l = mid + 1;
            } else if ((mid -1 >= 0 && nums[mid] <= nums[mid-1]) && (mid+1 == n || nums[mid] > nums[mid+1])){
                r = mid - 1;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }

    @Test
    public void show() {
        int[] arr = new int[]{1,2,1,2,1};
        System.out.println(findPeakElement(arr));
    }
}
