package codetop_byte.q0507;

import org.junit.jupiter.api.Test;

public class EqualSubstring {
    public int equalSubstring(String s, String t, int maxCost) {
        int m = s.length();

        int[] f = new int[m];
        for(int i = 0; i < m; i++) {
            f[i] = Math.abs(s.charAt(i)-t.charAt(i));
        }
        int res = 0;
        int l = -1,r = -1;
        while(l+1 < m) {
            while(r+1<m && maxCost-f[r+1]>=0) {
                maxCost-=f[r+1];
                r++;
            }
            res = Math.max(res,r-l);
            l++;
            maxCost+=f[l];
        }
        return res;
    }
    @Test
    public void show(){
        String s = "abcd";
        String t = "bcdf";
        System.out.println(equalSubstring(s,t,3));
    }
}
