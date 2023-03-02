package codetop_byte.q0302;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 1 || n == 1) {
            if (m == 1) {
                for(int i = 0; i < n; i++){
                    res.add(matrix[0][i]);
                }
            }else if(n == 1){
                for(int i = 0; i < m; i++) {
                    res.add(matrix[i][0]);
                }
            }else{
                res.add(matrix[0][0]);
            }
            return res;
        }
        int l = 0, r = n-1, t = 0, b = m-1;

        while(l < r && t < b) {
            for(int i = l; i < r; i++){
                res.add(matrix[t][i]);
            }
            for(int i = t; i < b; i++) {
                res.add(matrix[i][r]);
            }
            for(int i = r; i > l; i--) {
                res.add(matrix[b][i]);
            }

            for(int i = b; i > t; i--){
                res.add(matrix[i][l]);
            }
            l++;r--;t++;b--;
            if(l == r || t == b){
                if(l != r){
                    for (int i = l; i <= r; i++){
                        res.add(matrix[t][i]);
                    }
                }else if(t != b) {
                    for (int i = t; i <= b; i++) {
                        res.add(matrix[i][r]);
                    }
                }else{
                    res.add(matrix[t][l]);
                }
            }
        }

        return res;
    }
}
