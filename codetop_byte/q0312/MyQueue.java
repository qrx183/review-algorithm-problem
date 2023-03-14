package codetop_byte.q0312;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {
    Deque<Integer> d1;
    Deque<Integer> d2;
    public MyQueue() {
        d1 = new LinkedList<>();
        d2 = new LinkedList<>();
    }

    public void push(int x) {
        d1.push(x);
    }

    public int pop() {
        if(!d2.isEmpty()){
            return d2.pop();
        }
        while(!d1.isEmpty()){
            d2.push(d1.pop());
        }
        return d2.pop();
    }

    public int peek() {
        if(!d2.isEmpty()){
            return d2.peek();
        }
        while(!d1.isEmpty()){
            d2.push(d1.pop());
        }
        return d2.peek();
    }

    public boolean empty() {
        return d1.isEmpty() && d2.isEmpty();
    }
}
