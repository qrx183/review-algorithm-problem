package codetop_byte.q0302;

import org.junit.jupiter.api.Test;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer> map = new HashMap<>();
       int[] res = new int[2];
       int n = nums.length;
       for(int i = 0; i < n; i++){
           map.put(nums[i],i);
       }
       for(int i = 0; i < n; i++) {
           if(map.containsKey(target-nums[i]) && i != map.get(target-nums[i])){
               return new int[]{i,map.get(target-nums[i])};
           }
       }
       return res;
    }
    @Test
    public void show(){
        int[] arr = {3,2,4};
        System.out.println(Arrays.toString(twoSum(arr, 6)));
    }
}