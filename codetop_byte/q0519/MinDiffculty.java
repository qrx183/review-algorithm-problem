package codetop_byte.q0519;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

public class MinDiffculty {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d) {
            return -1;
        }
        int[][] maxJobDiff = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                for(int k = i; k <= j; k++) {
                    maxJobDiff[i][j] = Math.max(maxJobDiff[i][j],jobDifficulty[k]);
                }
            }
        }
        if(d == 1) {
            return maxJobDiff[0][n-1];
        }
        // f[i][j] 表示第i天完成前j项工作的最小难度
        // f[i][j] = min(f[i-1][k]+maxJob[k+1][j])
        int[][] f = new int[d+1][n];
        for(int i = 0; i <= d; i++) {
            Arrays.fill(f[i],300005);
        }
        for(int i = 0; i < n; i++) {
            f[1][i] = maxJobDiff[0][i];
        }
        for(int i = 2; i <= d; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k + 1 <= j; k++) {
                    f[i][j] = Math.min(f[i][j],f[i-1][k]+maxJobDiff[k+1][j]);
                }
            }
        }
        return f[d][n-1] == 2000 ? -1 : f[d][n-1];


    }
    @Test
    public void show() {
        int[] arr = {380,302,102,681,863,676,243,671,651,612,162,561,394,856,601,30,6,257,921,405,716,126,158,476,889,699,668,930,139,164,641,801,480,756,797,915,275,709,161,358,461,938,914,557,121,964,315};
        System.out.println(minDifficulty(arr,10));
    }
}
