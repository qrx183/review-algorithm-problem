package codetop_byte.q0610;

import java.util.Scanner;

public class EatChickenNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0; i < T; i++) {
            int res = 0;
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();
            int D = scanner.nextInt();
            res += D;
            if (C <= A) {
                res += C;
                A-=C;
            }else{
                res += A;
                A = 0;
            }
            res += B/2;
            B = B%2;
            while(B >= 2 * A && B > 0 && A > 0) {
                res ++;
                B--;
                A-=2;
            }
            System.out.println(res);
        }
    }
}
