package codetop_byte.q0412;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int m = s.length();
        int ans = 0;
        String res = "";
        boolean[][] f = new boolean[m][m];
        for(int i = 0; i < m; i++) {
            ans = 1;
            res = s.substring(i,i+1);
            f[i][i] = true;
        }
        for(int i = 0; i < m-1;i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                ans = 2;
                res = s.substring(i,i+2);
                f[i][i+1] = true;
            }
        }
        for(int i = 3; i <= m; i++) {
            for(int j = 0; j + i <= m; j++){
                int l = j,r = i + j - 1;
                if(s.charAt(l) == s.charAt(r)) {
                    f[l][r] = f[l][r] || f[l+1][r-1];
                }
                if (r-l+1 >= ans) {
                    ans = r-l+1;
                    res = s.substring(l,r+1);
                }
            }
        }
        return res;
    }
}
