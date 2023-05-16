package codetop_byte.q0516;

import java.util.Arrays;
import java.util.Scanner;

public class RestoreString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = s.length();
        if(n == 3) {
            if(s.charAt(0) == '1' || s.charAt(0) == '?' && s.charAt(2) == '1' || s.charAt(2) == '?') {
                if(s.charAt(1) != '?') {
                    System.out.println(s.charAt(1) == '0' ? "101":"121");
                }else{
                    System.out.println("121");
                }
                return;
            }
        }
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '1') {
                System.out.println(-1);
                return;
            }
        }
        char[] arr = s.toCharArray();
        int be = -1;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) != '?') {
                be = i;
                break;
            }
        }
        if(be == -1) {
            for(int i = 0; i < n; i++) {
                arr[i] = i%2 == 0 ? '0':'2';
            }
            System.out.println(new String(arr));
            return;
        }
        for(int i = be-1; i >= 0; i--) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i+1);
            if(ch1 == '?') {
                arr[i] = ch2 == '0' ? '2' : '0';
            }else {
                if(ch1 == ch2) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        for(int i = be+1; i < n; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i-1);
            if(ch1 == '?') {
                arr[i] = ch2 == '0' ? '2' : '0';
            }else{
                if(ch1 == ch2) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(new String(arr));
    }
}
