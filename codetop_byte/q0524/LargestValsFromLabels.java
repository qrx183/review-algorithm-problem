package codetop_byte.q0524;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LargestValsFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int label = labels[i];
            PriorityQueue<Integer> p = map.getOrDefault(label,new PriorityQueue<>());
            if(p.size() < useLimit) {
                p.offer(values[i]);
            }else{
                if(p.peek() < values[i]) {
                    p.poll();
                    p.offer(values[i]);
                }
            }
            map.put(label,p);
        }
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int key : map.keySet()) {
            PriorityQueue<Integer> cur = map.get(key);
            while(!cur.isEmpty()) {
                if(p.size() < numWanted) {
                    p.offer(cur.peek());
                }else {
                    if(p.peek() < cur.peek()) {
                        p.poll();
                        p.offer(cur.peek());
                    }
                }
                cur.poll();
            }
        }
        int res = 0;
        while(!p.isEmpty()) {
            res += p.poll();
        }
        return res;
    }
    @Test
    public void show() {
        int[] values = {2,6,1,2,6};
        int[] labels = {2,2,2,1,1};
        System.out.println(largestValsFromLabels(values,labels,1,1));
    }
}
