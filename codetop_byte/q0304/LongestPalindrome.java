package codetop_byte.q0304;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        int cnt = 1;
        String ans = s.charAt(0)+"";
        for(int i = 0; i < n; i++){
            f[i][i] = true;
        }
        for(int len = 2; len <= n; len++){
            for(int i = 0; i <= n-len; i++){
                int j = i+len-1;

                if(s.charAt(i) == s.charAt(j)){
                    if(len == 2){
                        cnt = 2;
                        ans = s.substring(i,j+1);
                        f[i][j] = true;
                        continue;
                    }
                    f[i][j] = f[i+1][j-1];
                }
                if(f[i][j]){
                    if(cnt < len){
                        cnt = len;
                        ans = s.substring(i,j+1);
                    }
                }

            }
        }
        return ans;
    }
}
