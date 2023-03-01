package codetop_byte.q0227;

import org.junit.jupiter.api.Test;

import java.util.*;

public class ThreeSum {
    @Test
    public void test() {
        int[] nums = {34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};
        System.out.println(threeSum(nums));
    }
        // 三数之和 其实就是二数之和的演化，就是固定一个数的位置，对剩下两个数进行二数之和
        // 事实上 n数之和也是可以一直往上叠加的，只是n加1，时间复杂度上升一个数量级
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            Set<List<Integer>> set = new HashSet<>();
            int len = nums.length;
            if (len < 3) {
                return res;
            }
            int l = 0,mid = 1,r = nums.length-1;
            while (l < mid && mid < r) {
                for(; mid < r; mid ++){
                    while(mid < r && nums[l]+nums[mid]+nums[r] > 0) {
                        r--;
                    }
                    if (mid < r && nums[l] + nums[mid] + nums[r] == 0) {
                        List<Integer> curList = new ArrayList<>();
                        curList.add(nums[l]);
                        curList.add(nums[mid]);
                        curList.add(nums[r]);
                        set.add(curList);
                    }
                }
                r = nums.length - 1;
                l++;
                mid =  l + 1;

            }
            for (List<Integer> list: set) {
                res.add(list);
            }
            return res;
    }
}
