package codetop_byte.q0312;

import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParentheses {
    // dp
    // 最长有效括号 这个dp有点秀.
    // dp[i] = 2+dp[i-2]--->(dp[i] == ')' and dp[i-1] == '(')
    // dp[i] = 2+dp[i-1] + dp[i-dp[i-1]-2]
    public int longestValidParentheses1(String s) {
        int m = s.length();
        if (m == 0 || m == 1) {
            return 0;
        }
        int res = 0;
        int[] dp = new int[m];
        for(int i =1; i < m; i++) {
            if(s.charAt(i) == ')') {
                if(s.charAt(i-1) == '(') {
                    dp[i] = 2 + (i-2>=0 ? dp[i-2]:0);
                }else if(i-dp[i-1]>0 && s.charAt(i-dp[i-1]-1) == '(') {
                    dp[i] = 2 + dp[i-1] + (i-dp[i-1]-2>0 ? dp[i-dp[i-1]-2] : 0);
                }
                // else的情况:s.charAt(i-dp[i-1]-1) == ')',那么dp[i]的大小一定小于等于dp[i-1],所以没必要考虑
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
    public int longestValidParentheses(String s) {
        int m = s.length();
        if (m == 0 || m == 1) {
            return 0;
        }
        int res = 0;
        Deque<Integer> d = new LinkedList<>();
        d.push(-1);
        for(int i = 0;i < m; i++) {
            if(s.charAt(i) == '(') {
                d.push(i);
            }else{
                d.pop();
                if(d.isEmpty()) {
                    d.push(i);
                }else{
                    res = Math.max(res,i-d.peek());
                }
            }
        }
        return res;
    }
}
