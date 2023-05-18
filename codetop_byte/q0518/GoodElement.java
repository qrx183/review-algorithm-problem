package codetop_byte.q0518;

import java.util.Scanner;

public class GoodElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = i;
        }
        int cur = n % k == 0 ? n / k - 1 : n / k;
        int i = 1;
        while (i <= n) {
            int j = i + cur;
            if (j > n) {
                swap(f, i, n);
                break;
            }
            swap(f, i, j);
            i = j + 1;
        }
        for (i = 1; i <= n; i++) {
            System.out.print(f[i] + " ");
        }
    }

    private static void swap(int[] f, int i, int j) {
        int tmp = f[i];
        f[i] = f[j];
        f[j] = tmp;
    }
}
