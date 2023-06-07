package codetop_byte.q0606;

import java.util.Scanner;

public class BlackWhiteMagicNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        // f[i][0] 表示以i结尾的黑魔法乘积小于0的个数
        // f[i][1] 表示以i结尾的白魔法乘积大于0的个数
        int[][] f = new int[n][2];
        if(a[0] > 0) {
            f[0][1] = 1;
        }else{
            f[0][0] = 1;
        }
        int blackCnt = f[0][0],whiteCnt = f[0][1];
        for(int i = 1; i < n; i++) {
            if(a[i] > 0) {
                f[i][1] = 1 + f[i-1][1];
                f[i][0] = f[i-1][0];
            }else{
                f[i][0] = 1 + f[i-1][1];
                f[i][1] = f[i-1][0];
            }
            blackCnt += f[i][0];
            whiteCnt += f[i][1];
        }
        System.out.println(blackCnt + " " +whiteCnt);
    }
}
