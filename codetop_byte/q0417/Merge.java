package codetop_byte.q0417;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Merge {
    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int m = intervals.size();
        if (m <= 1) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });
        ArrayList<Interval> res = new ArrayList<>();
        int i = 0;
        while (i < m) {
            Interval interval = intervals.get(i);
            while (i + 1 < m && interval.end >= intervals.get(i + 1).start) {
                interval.end = Math.max(interval.end, intervals.get(i + 1).end);
                i++;
            }
            res.add(interval);
            i++;
        }
        return res;
    }
}
