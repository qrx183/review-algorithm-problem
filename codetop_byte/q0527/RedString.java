package codetop_byte.q0527;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RedString {
    private static final Map<Integer,Integer> map = new HashMap<>();
    static {
     for(int i = 1; i <= 100000; i *= 10) {
         map.put(i,i*(i+1)/2);
     }
    }
    private static final String s = "red";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        StringBuilder res = new StringBuilder();
        int index = 0;
        while(x > 0) {
            for(int j = 100000; j >= 1; j/=10) {
                if(map.get(j) <= x) {
                    x-=map.get(j);
                    for(int k = 0; k < map.get(j); k++) {
                        res.append(s.charAt(index));
                    }
                }
            }
            index = (index + 1) % 3;
        }
        System.out.println(res);
    }
}
