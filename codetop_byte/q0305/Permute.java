package codetop_byte.q0305;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums,0);
        return res;
    }

    private void dfs(int[] nums,int index) {
        if (index == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for (int num : nums) {
                cur.add(num);
            }
            res.add(cur);
            return;
        }
        for (int i = index;i < nums.length; i++) {
            swap(nums,i,index);
            dfs(nums,index+1);
            swap(nums,i,index);
        }
    }

    private void swap(int[] nums,int i,int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void show(){
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}

