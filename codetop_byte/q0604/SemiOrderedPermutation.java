package codetop_byte.q0604;

import org.junit.jupiter.api.Test;

public class SemiOrderedPermutation {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        if(nums[0] == 1 && nums[n-1] == n) {
            return 0;
        }
        int res = 0;
        int target = 1;
        int index = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == target) {
                index = i;
                break;
            }
        }
        swap(nums,0,index);
        res += index;
        target = n;
        for(int i = 0; i < n; i++) {
            if(nums[i] == target) {
                index = i;
                break;
            }
        }
        swap(nums,index,n-1);
        return  res+n-1-index;
    }
    private void swap(int[] nums,int l,int r) {
        int tmp = nums[r];
        for(int i = r; i > l; i--) {
            nums[i] = nums[i-1];
        }
        nums[l] = tmp;
    }
    @Test
    public void show() {
        int[] nusm = {3,4,2,1};
        System.out.println(semiOrderedPermutation(nusm));
    }
}
