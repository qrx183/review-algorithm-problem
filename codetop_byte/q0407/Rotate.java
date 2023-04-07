package codetop_byte.q0407;

public class Rotate {
    public void rotate(int[][] matrix) {
        // 原地旋转图像
        // 按照4个角进行处理,每次旋转对应的4个值,然后一层一层的往里旋([0,n-1] -> [1,n-2] -> ...)
        int m = matrix.length;
        if (m == 1) {
            return;
        }
        int i = m - 1;
        int n = 0;
        while (n != i && n - 1 != i) {
            for (int j = n; j < i; j++) {
                int temp = matrix[n][j];
                int temp1 = matrix[j][i];
                matrix[j][i] = temp;
                int temp2 = matrix[i][i - (j - n)];
                matrix[i][i - (j - n)] = temp1;
                int temp3 = matrix[i - (j - n)][n];
                matrix[i - (j - n)][n] = temp2;
                matrix[n][j] = temp3;
            }
            i--;
            n++;
        }
    }
}
