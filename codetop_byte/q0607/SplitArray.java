package codetop_byte.q0607;

import java.util.Arrays;
import java.util.Scanner;

public class SplitArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        double res = 0;
        for(int i = 0; i < k-1; i++) {
            res += arr[i];
        }
        long sum = 0;
        for(int i = k-1; i < n; i++) {
            sum += arr[i];
        }
        res += 1.0*sum/(n-k+1);
        System.out.println(res);
    }
}
