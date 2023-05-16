package codetop_byte.q0515;

import java.util.*;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans2 = new int[n];
        Arrays.fill(ans2,-1);
        Deque<Integer> d = new LinkedList<>();
        int i = 0;
        while(i < n) {
            while(!d.isEmpty() && nums2[d.peek()] < nums2[i]){
                ans2[d.peek()] = nums2[i];
                d.pop();
            }
            d.push(i);
            i++;
        }
        int[] ans1 = new int[m];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int j = 0; j < m; j++) {
            List<Integer> l = map.get(nums1[j]);
            if(l == null) {
                l = new ArrayList<>();
            }
            l.add(j);
            map.put(nums1[j],l);
        }
        for(int j = 0; j < n; j++) {
            List<Integer> l = map.get(nums2[j]);
            if(l == null) {
                l = new ArrayList<>();
            }
            l.add(j);
            map.put(nums2[j],l);
        }
        for(int j = 0; j < m; j++) {
            List<Integer> l = map.get(nums1[j]);
            ans1[j] = ans2[l.get(1)];
        }
        return ans1;
    }
}
