package codetop_byte.q0521;

import org.junit.jupiter.api.Test;

public class MinLength {
    public int minLength(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        while(hasValid(sb)) {
            int i = 0;
            while(i < sb.length()) {
                if(i+1 < sb.length() && (sb.substring(i,i+2).equals("AB")||sb.substring(i,i+2).equals("CD"))) {
                    sb.delete(i,i+2);
                }else{
                    i++;
                }
            }
        }
        return sb.length();
    }
    private boolean hasValid(StringBuilder s) {
        int n = s.length();
        for(int i = 0; i < n; i++) {
            if(i+1 < n && (s.substring(i,i+2).equals("AB")||s.substring(i,i+2).equals("CD"))) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void show() {
        String s = "ABFCACDB";
        System.out.println(minLength(s));
    }
}
