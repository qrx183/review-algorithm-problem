package codetop_byte.q0605;

import java.util.Scanner;

public class MeiStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int res = 0;
        int i = 0;
        int n = s.length();
        while(i < n) {
            int cnt = 1;
            while(i + 1 < n && s.charAt(i) == s.charAt(i+1)) {
                cnt++;
                i++;
            }
            res += cnt / 2;
            i++;
        }
        System.out.println(res);
    }
}
