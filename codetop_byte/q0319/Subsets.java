package codetop_byte.q0319;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums,0,new ArrayList<Integer>());
        for (List<Integer> l : set) {
            res.add(l);
        }
        return res;
    }
    private void dfs(int[] nums,int index,List<Integer> l) {
        if (index == nums.length) {
            set.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[index]);
        dfs(nums,index+1,l);
        l.remove(l.size()-1);
        dfs(nums,index+1,l);
    }
    @Test
    public void show() {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}
