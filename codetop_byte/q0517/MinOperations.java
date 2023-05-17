package codetop_byte.q0517;

import java.util.Scanner;

public class MinOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String s = scanner.next();
        int l = 0, r = 200000;
        while(l < r) {
            int mid = l + (r-l>>1);
            if(check(s,mid,a,b)) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        if(l == 0) {
            System.out.println(-1);
        }else{
            System.out.println(l);
        }
    }
    private static boolean check(String s,int cnt,int a,int b) {

    }
}
