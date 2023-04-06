package codetop_byte.q0406;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] f = new int[m+1][n+1];

        for(int i =1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                char ch1 = text1.charAt(i-1);
                char ch2 = text2.charAt(j-1);
                if(ch1 == ch2) {
                    f[i][j] = Math.max(f[i][j],f[i-1][j-1]+1);
                }else{
                    f[i][j] = Math.max(f[i-1][j],f[i][j-1]);
                }
            }
        }
        return f[m][n];

    }
}
