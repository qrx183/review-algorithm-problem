package codetop_byte.q0310;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int res = 0;
        int n = matrix[0].length;
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++) {
            arr[i][0] = matrix[i][0] == '1' ? 1 : 0;
            res = Math.max(res,arr[i][0]);
        }
        for(int j = 0; j < n; j++) {
            arr[0][j] = matrix[0][j] == '1' ? 1 : 0;
            res = Math.max(res,arr[0][j]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (arr[i-1][j] != 0 && arr[i][j-1] != 0 && arr[i-1][j-1] != 0) {
                        int m1 = (int)(Math.min(Math.pow(arr[i-1][j],0.5),Math.pow(arr[i][j-1],0.5)))+1;
                        int m2 = (int)(Math.min(Math.pow(arr[i-1][j-1],0.5)+1,m1));
                        arr[i][j] = (int)(Math.pow(m2,2));
                    }else{
                        arr[i][j] = 1;
                    }
                    res = Math.max(arr[i][j],res);
                }
            }
        }
        return res;
    }
}
