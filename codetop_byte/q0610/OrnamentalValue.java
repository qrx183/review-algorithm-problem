package codetop_byte.q0610;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class OrnamentalValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][3];
        for(int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++) {
            arr[i][1] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++) {
            arr[i][2] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++) {
            int pos = arr[i][0];
            int r = arr[i][1];
            arr[i][0] = pos-r;
            arr[i][1] = pos+r;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int[][] f = new int[n][2];
        f[0][1] = arr[0][2];
        for(int i = 1; i < n; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(arr[j][1] <= arr[i][0]){
                    f[i][1] = Math.max(f[i][1],f[j][1]+arr[i][2]);
                }
                f[i][1] = Math.max(f[i][1],arr[i][2]);
                f[i][0] = Math.max(f[i][0],Math.max(f[i-1][0],f[i-1][1]));
            }
        }
        System.out.println(Math.max(f[n-1][0],f[n-1][1]));
    }
}
