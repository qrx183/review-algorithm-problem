package codetop_byte.q0605;

import java.util.Arrays;
import java.util.Scanner;

public class PeekGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] heights = new int[n];
        for(int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }
        int[] lMins = new int[n];
        int[] rMins = new int[n];
        Arrays.fill(lMins,1);
        Arrays.fill(rMins,1);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(heights[j] < heights[i]) {
                    lMins[i] = Math.max(lMins[i],lMins[j]+1);
                }
            }
        }
        for(int i = n-2; i >= 0; i--) {
            for(int j = i+1; j < n; j++) {
                if(heights[j] < heights[i]) {
                    rMins[i] = Math.max(rMins[i],rMins[j]+1);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            // 这里虽然有的分割点得到的并不是准确值，但是对于得出异常结果的分割点，其实也可以通过异常点的左右相邻点得出正确结果
            res = Math.min(res,n+1-lMins[i]-rMins[i]);
        }
        System.out.println(res);
    }
}
