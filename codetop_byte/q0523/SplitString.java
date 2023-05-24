package codetop_byte.q0523;

import java.lang.invoke.MutableCallSite;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SplitString {
    public static void main(String[] args) {
        // 最大最小值,典型二分
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int k = scanner.nextInt();
        int n = s.length();
        if(n == k) {
            System.out.println(1);
        }
        int l = 1,r = 26*500000;
        while(l < r) {
            int mid = l + r >> 1;
            if(check(s,k,mid)) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        System.out.println(l);
    }
    private static boolean check(String s,int k,int target) {
        int n = s.length();
        int l = -1;
        while(l + 1 < n) {
            int curT = 0;
            Set<Character> set = new HashSet<>();
            int size = 0;
            while(l + 1 < n && (curT = set.contains(s.charAt(l+1)) ? (size+1)*(set.size()):(size+1)*(set.size()+1)) <= target) {
                set.add(s.charAt(l+1));
                l++;
                size++;
            }
            k--;
            if(l+1 >= n) {
                break;
            }
        }
        return k >= 0;
    }
}
