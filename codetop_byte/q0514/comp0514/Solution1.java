package codetop_byte.q0514.comp0514;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution1 {
    public int[] circularGameLosers(int n, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        int cur = 1;
        for(int i = 1; i <= n; i++) {
            map.put(i,0);
        }
        map.put(cur,1);
        int i = 1;
        while(true) {
            cur = (cur+i*k) % n;
            if(cur == 0) {
                cur = n;
            }
            map.put(cur,map.getOrDefault(cur,0)+1);
            if(map.get(cur) == 2) {
                List<Integer> l = new ArrayList<>();
                for(int key : map.keySet()) {
                    if(map.get(key) == 0) {
                        l.add(key);
                    }
                }
                Collections.sort(l);
                int[] res = new int[l.size()];
                for(int j = 0; j < res.length; j++) {
                    res[j] = l.get(j);
                }
                return res;
            }
            i++;
        }
    }
    @Test
    public void show() {
        System.out.println(Arrays.toString(circularGameLosers(2, 1)));
    }
}
