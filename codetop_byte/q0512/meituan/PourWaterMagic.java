package codetop_byte.q0512.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class PourWaterMagic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] V = new int[n];
        int[] initial = new int[n];
        int[] energy = new int[n];
        int m;

        for(int i = 0; i < n; i++) {
            V[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++) {
            initial[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++) {
            energy[i] = scanner.nextInt();
        }
        m = scanner.nextInt();

        int[] q = new int[m];
        for(int i = 0; i < m; i++) {
            q[i] = scanner.nextInt();
        }

        int[] f = new int[n];
        int[] sums = new int[n+1];
        sums[1] = V[0]-initial[0];
        for(int i = 2; i <= n; i++) {
            sums[i] += sums[i-1]+V[i-1]-initial[i-1];
        }
        Arrays.fill(f,Integer.MAX_VALUE);
        f[0] = (V[0]-initial[0])*energy[0];
        for(int i = 1; i < n; i++) {
            for(int j = 0;j <= i; j++) {
                if(energy[j] >= energy[i]){
                    continue;
                }
                f[i] = Math.min(f[i],energy[j]*(sums[i+1]-sums[j]));
            }
        }
        for(int i = 0; i < m; i++) {
            System.out.print(f[q[i]-1]);
            if(i != m-1) {
                System.out.print(" ");
            }
        }
    }
}
