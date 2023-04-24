package codetop_byte.q0424;

import java.util.*;

public class RandomMing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if(!set.contains(num)) {
                set.add(num);
                l.add(num);
            }
        }
        Collections.sort(l);
        for(int num : l) {
            System.out.println(num);
        }
    }
}
