package codetop_byte.q0608;

import java.util.Scanner;

public class MultiplesOfP {
    private static long n;
    private static long p;
    private static String res;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextLong();
        p = scanner.nextLong();
        if(p % n == 0) {
            System.out.println(n);
            return;
        }
        long cur = n;
        dfs(new StringBuilder(String.valueOf(n)),0);
        System.out.println(n==cur ? -1 : res);
    }
    private static void dfs(StringBuilder s,int i) {

        n = Long.parseLong(new String(s));
        if(p % n == 0) {
            res = new String(s);
            return;
        }
        if(i >= s.length()) {
            return;
        }
        if(s.charAt(i) == '0') {
            s.setCharAt(i,'1');
            dfs(s,i+1);
            if(p % n == 0) {
                res = new String(s);
                return;
            }
            s.setCharAt(i,'0');
            n = Long.parseLong(new String(s));
        }else if(s.charAt(i) == '9') {
            s.setCharAt(i,'8');
            dfs(s,i+1);
            if(p % n == 0) {
                res = new String(s);
                return;
            }
            s.setCharAt(i,'9');
            n = Long.parseLong(new String(s));
        }else{
            char ch = s.charAt(i);
            s.setCharAt(i,(char)(ch-1));
            dfs(s,i+1);
            if(p % n == 0) {
                res = new String(s);
                return;
            }
            s.setCharAt(i,(char)(ch+1));
            dfs(s,i+1);
            if(p % n == 0) {
                res = new String(s);
                return;
            }
            s.setCharAt(i,ch);
            n = Long.parseLong(new String(s));
        }
    }
}
