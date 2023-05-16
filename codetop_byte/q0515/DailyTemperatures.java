package codetop_byte.q0515;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> d = new LinkedList<>();
        int i = 0;
        while(i < n) {
            while(!d.isEmpty() && temperatures[d.peek()] < temperatures[i]){
                ans[d.peek()] = i-d.peek();
                d.pop();
            }
            d.push(i);
            i++;
        }
        return ans;
    }
}
