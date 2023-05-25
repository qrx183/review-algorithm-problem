package codetop_byte.q0525.meituan;

import java.util.*;

public class LongestRibbon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Deque<Integer> d = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int l = -1,r = -1;
        int count = 0;
        int res = 0;
        while(true) {
            while(r+1<n && (count < k || (count == k && (map.get(nums[r+1]) != null && map.get(nums[r+1]) > 0)))) {
                r++;
                d.offerLast(r);
                if(map.get(nums[r]) != null && map.get(nums[r]) != 0) {
                    map.put(nums[r],map.getOrDefault(nums[r],0)+1);
                }else{
                    map.put(nums[r],1);
                    count++;
                }
            }
            res = Math.max(res,r-l);
            while(l+1 < n && map.get(nums[l+1]) != 1) {
                l++;
                map.put(nums[l],map.get(nums[l])-1);
            }
            l++;
            map.put(nums[l],map.get(nums[l])-1);
            l++;
            count--;
            if(l > r || r == n-1) {
                break;
            }

        }
        System.out.println(res);
    }
}
