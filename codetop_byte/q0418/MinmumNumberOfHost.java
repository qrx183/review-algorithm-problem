package codetop_byte.q0418;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class MinmumNumberOfHost {
    public int minmumNumberOfHost(int n, int[][] startEnd) {
        // write code here
        if (n == 1) {
            return 1;
        }
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++ ){
            start[i] = startEnd[i][0];
            end[i] = startEnd[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        return 0;
    }
    @Test
    public void show(){

    }
}
