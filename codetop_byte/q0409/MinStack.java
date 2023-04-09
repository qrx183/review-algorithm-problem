package codetop_byte.q0409;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    Deque<Integer> s;
    Deque<Integer> minS;
    public MinStack() {
        s = new LinkedList<>();
        minS = new LinkedList<>();
    }

    public void push(int val) {
        s.push(val);
        if (minS.isEmpty() || minS.peek() >= val) {
            minS.push(val);
        }else{
            minS.push(minS.peek());
        }
    }

    public void pop() {
        s.pop();
        minS.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minS.peek();
    }
}
