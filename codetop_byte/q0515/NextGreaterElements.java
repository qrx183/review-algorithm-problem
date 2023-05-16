package codetop_byte.q0515;

import org.junit.jupiter.api.Test;

import java.util.*;

public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        // 循环可以通过重复排列2次代替,但需要注意的是在n之后的元素不应该在放到栈中,单调栈中应该只保存前n个元素
        int n = nums.length;
        int[] curNums = new int[n*2];
        for(int i = 0; i < n*2;i++) {
            curNums[i] = nums[i%n];
        }
        Deque<Integer> d = new LinkedList<>();
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        int index = 0;
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while(i < 2*n) {
            while(!d.isEmpty() && curNums[d.peek()] < curNums[i]) {
                ans[d.peek()] = curNums[i];
                d.pop();
            }

            if(set.contains(i%n)){
                i++;
                continue;
            }
            set.add(i);
            d.push(i);
            i++;

        }
        return ans;
    }
    @Test
    public void show() {
//        int[] nums = {1,2,3,4,3};
//        System.out.println(Arrays.toString(nextGreaterElements(nums)));
        System.out.println(277/290.0);
    }
}
