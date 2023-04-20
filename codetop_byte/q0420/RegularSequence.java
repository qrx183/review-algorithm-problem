package codetop_byte.q0420;

import java.util.Arrays;
import java.util.Scanner;

public class RegularSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] f = new int[n];
        for(int i = 0; i < n; i++) {
            f[i] = scanner.nextInt();
        }
        Arrays.sort(f);
        int res = 0;
        for(int i = 0; i < n; i++) {
            res += Math.abs(f[i]-(i+1));
        }
        System.out.println(res);
    }
}
