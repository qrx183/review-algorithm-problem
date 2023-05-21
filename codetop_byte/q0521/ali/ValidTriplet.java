package codetop_byte.q0521.ali;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ValidTriplet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 这道题只是规定了i<j<k ,但是对于a[i],a[j],a[k]的大小关系没有限制,所以无需考虑下表之间的大小关系
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            map.put(num,map.getOrDefault(num,0)+1);
        }
        long res = 0;
        for(int key : map.keySet()) {
            int cnt1 = map.get(key);
            int cnt2 = map.get(key+1);
            if(cnt2 == 0) {
                continue;
            }
            res += (long) cnt1 * cnt2 * (cnt2-1)/2;
            res += (long) cnt2 * cnt1 * (cnt1-1)/2;
        }
        System.out.println(res);
    }
}
