package codetop_byte.q0604;

import org.junit.jupiter.api.Test;

public class MinimizedStringLength {
    public int minimizedStringLength(String s) {
        int n = s.length();
        StringBuffer sb = new StringBuffer(s);
        int i = 0;
        while(i < sb.length()) {
            char ch = sb.charAt(i);
            int l = i-1,r = i+1;
            boolean flag = false;
            while(l >= 0) {
                if(sb.charAt(l) == ch) {
                    flag = true;
                    sb.deleteCharAt(l);
                    break;
                }
                l--;
            }
            while(r < sb.length()) {
                if(sb.charAt(r) == ch) {
                    flag = true;
                    sb.deleteCharAt(r);
                    break;
                }
                r++;
            }
            if(!flag) {
                i++;
            }
        }
        return sb.length();
    }
    @Test
    public void show() {
        String s = "dddaaa";
        System.out.println(minimizedStringLength(s));
    }
}
