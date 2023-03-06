package codetop_byte.q0306;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class IsValid {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }else  {
                if (stack.size() == 0) {
                    return false;
                }
                if (ch == ')') {
                    if (stack.pop() != '('){
                        return false;
                    }
                } else if(ch == ']') {
                    if (stack.pop() != '[') {
                        return false;
                    }
                } else {
                    if (stack.pop() != '{') {
                        return false;
                    }
                }
            }
        }
        return stack.size() == 0;
    }

    @Test
    public void show() {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}
