package codetop_byte.q0416;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int[][] f = new int[m][m];
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            Arrays.fill(f[i],Integer.MAX_VALUE);
        }
        for(int i = 0; i < m; i++) {
            f[0][i] = matrix[0][i];
            if(m == 1) {
                res = Math.min(res,f[0][i]);
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 0; j < m;j++) {
                f[i][j] = Math.min(f[i][j],f[i-1][j]+matrix[i][j]);
                if(j-1 >= 0) {
                    f[i][j] = Math.min(f[i][j],f[i-1][j-1]+matrix[i][j]);
                }
                if(j+1 < m) {
                    f[i][j] = Math.min(f[i][j],f[i-1][j+1]+matrix[i][j]);
                }
                if(i == m-1) {
                    res = Math.min(res,f[i][j]);
                }
            }
        }
        return res;

    }

    @Test
    public void show() {
        int[][] arr = {{17,82},{1,-44}};
        System.out.println(minFallingPathSum(arr));
    }
}
