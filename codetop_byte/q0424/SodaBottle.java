package codetop_byte.q0424;

import java.util.Scanner;

public class SodaBottle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        while(num != 0) {
            int res = 0;
            while(num > 2) {
                res += num/3;
                num = num/3 + num % 3;
            }
            if(num == 2) {
                res += 1;
            }

            System.out.println(res);
            num = scanner.nextInt();
        }
    }
}
