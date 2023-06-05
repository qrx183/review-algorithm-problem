package codetop_byte.q0528;

import java.util.HashSet;
import java.util.Set;

public class DifferenceOfDistinctValues {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] answer = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int lr = i-1,lc = j-1;
                int rr = i+1,rc = j+1;
                Set<Integer> lSet = new HashSet<>();
                Set<Integer> rSet = new HashSet<>();
                while(lr >= 0 && lc >= 0) {
                    lSet.add(grid[lr][lc]);
                    lr--;
                    lc--;
                }
                while(rr < m && rc < n) {
                    rSet.add(grid[rr][rc]);
                    rr++;
                    rc++;
                }
                answer[i][j] = Math.abs(lSet.size()-rSet.size());
            }
        }
        return answer;
    }
}
