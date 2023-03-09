package codetop_byte.q0309;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int m = intervals.length;
        int i = 0;
        while(i < m) {
            int[] interval = intervals[i];
            while(i + 1 < m && interval[1] >= intervals[i+1][0]) {
                interval[1] = Math.max(interval[1],intervals[i+1][1]);
                i++;
            }
            list.add(interval);
        }
        int[][] res = new int[list.size()][2];
        i = 0;
        for (int[] interval : list) {
            res[i++] = interval;
        }
        return res;
    }
}
