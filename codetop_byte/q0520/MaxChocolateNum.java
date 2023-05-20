package codetop_byte.q0520;

import java.util.Arrays;
import java.util.Scanner;

public class MaxChocolateNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] sum = new int[n+1];
        int[] qs = new int[m];
        int[] lens = new int[n+1];
        for(int i = 1; i<= n; i++) {
            lens[i] = scanner.nextInt();
        }
        Arrays.sort(lens);
        for(int i = 1; i <= n; i++) {
            int len = lens[i];
            if(i == 1) {
                sum[i] = len * len;
            }else{
                sum[i] = sum[i-1]+len*len;
            }
        }
        for(int i = 0; i < m; i++) {
            qs[i] = scanner.nextInt();
        }
        for(int i = 0; i < m; i++) {
            int q = qs[i];
            int l = 1, r = n;
            while(l < r) {
                int mid = l + (r-l+1>>1);
                if(sum[mid] <= q) {
                    l = mid;
                }else{
                    r = mid - 1;
                }
            }
            if(l == 1 && sum[l] > q) {
                if(i != m-1) {
                    System.out.print(0 + " ");
                }else{
                    System.out.println(0);
                }

            }else {
                if (i != m - 1) {
                    System.out.print(l + " ");
                } else {
                    System.out.println(l);
                }
            }
        }
    }
}
