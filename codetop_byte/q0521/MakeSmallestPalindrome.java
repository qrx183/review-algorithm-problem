package codetop_byte.q0521;

public class MakeSmallestPalindrome {
    public String makeSmallestPalindrome(String s) {
        int n = s.length();
        char[] res = s.toCharArray();
        for(int i = 0; i < n/2;i++) {
            int l = i;
            int r = n-i-1;
            if(s.charAt(l) != s.charAt(r)) {
                if(s.charAt(l) < s.charAt(r)) {
                    res[r] = s.charAt(l);
                }else{
                    res[l] = s.charAt(r);
                }
            }
        }
        return new String(res);
    }
}
