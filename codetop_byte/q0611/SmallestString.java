package codetop_byte.q0611;

import org.junit.jupiter.api.Test;

public class SmallestString {
    public String smallestString(String s) {
        int n = s.length();
        int l = 0;
        while(l < n && s.charAt(l) == 'a') {
            l++;
        }
        if(l >= n) {
            return s.substring(0,n-1)+'z';
        }
        int r = l + 1;
        while(r < n && s.charAt(r) != 'a') {
            r++;
        }
        char[] chs = s.toCharArray();
        for(int i = l; i < r; i++) {
            chs[i] = (char)((chs[i]-1));
        }
        return new String(chs);
    }
    @Test
    public void show() {
        String s = "a";
        System.out.println(smallestString(s));
    }
}
