package codetop_byte.q0524.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class BestPlan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        char[][] map = new char[n][m];
        int[][] values = new int[n][m];
        for(int i = 0; i < n; i++) {
            String s = scanner.next();
            for(int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                values[i][j] = scanner.nextInt();
            }
        }
        int res = 0;
        int[][] f = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(f[i],-1000000);
        }
        f[0][0] = 0;
        for(int i = 1; i < n; i++) {
            if(map[i-1][0] == map[i][0]) {
                f[i][0] = f[i-1][0] + values[i][0];
            }else {
                f[i][0] = f[i-1][0] + values[i][0] - k;
            }
            res = Math.max(res,f[i][0]);
        }
        for(int i = 1; i < m; i++) {
            f[0][i] = f[0][i-1] + values[0][i] - (map[0][i-1] == map[0][i] ? 0 : k);
            res = Math.max(res,f[0][i]);
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                int r = f[i][j-1] + values[i][j] - (map[i][j-1] == map[i][j] ? 0 : k);
                int d = f[i-1][j] + values[i][j] - (map[i-1][j] == map[i][j] ? 0 : k);
                f[i][j] = Math.max(f[i][j],Math.max(r,d));
                res = Math.max(res,f[i][j]);
            }
        }
        System.out.println(res);
    }
}
