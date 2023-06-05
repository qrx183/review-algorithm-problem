package codetop_byte.q0604;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MatrixSumQueries {
    public long matrixSumQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] zeroCnt = new int[m];
        int[] oneCnt = new int[m];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = m-1; i >= 0; i--) {
            int key = queries[i][0]*n+queries[i][1];
            map.put(key,map.getOrDefault(key,0)+1);
            if(map.get(key) > 1) {
                queries[i][0] = -1;
            }
        }
        for(int i = m-2; i>=0;i--) {
            if(queries[i+1][0] == -1) {
                zeroCnt[i] = zeroCnt[i+1];
                oneCnt[i] = oneCnt[i+1];
                continue;
            }
            if(queries[i+1][0] == 1) {
                zeroCnt[i] = zeroCnt[i+1];
                oneCnt[i] = oneCnt[i+1]+1;
            }else{
                zeroCnt[i] = zeroCnt[i+1]+1;
                oneCnt[i] = oneCnt[i+1];
            }
        }
        long res = 0;
        for(int i = m-1; i >= 0; i--) {
            if(queries[i][0] == -1){
                continue;
            }
            if(queries[i][0] == 1) {
                res += (long) queries[i][2] * (Math.max(n - zeroCnt[i], 0));
            }else{
                res += (long) queries[i][2] * (Math.max(n - oneCnt[i], 0));
            }
        }
        return res;
    }
    @Test
    public void show() {
        int[][] q = {
                {0,6,30094},{0,7,99382},{1,2,18599},{1,3,49292},{1,0,81549},{1,1,38280},{0,0,19405},{0,4,30065},{1,4,60826},{1,5,9241},{0,5,33729},{0,1,41456},{0,2,62692},{0,3,30807},{1,7,70613},{1,6,9506},{0,5,39344},{1,0,44658},{1,1,56485},{1,2,48112},{0,6,43384}};
        System.out.println(matrixSumQueries(8,q));

    }
}
