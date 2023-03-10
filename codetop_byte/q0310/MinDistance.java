package codetop_byte.q0310;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0 || n == 0) {
            return m == 0 ? n : m;
        }
        int[][] f = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            f[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            f[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                char ch1 = word1.charAt(i-1);
                char ch2 = word2.charAt(j-1);
                if (ch1 == ch2) {
                    f[i][j] = f[i-1][j-1];
                }else {
                    f[i][j] = Math.min(f[i-1][j-1],Math.min(f[i][j-1],f[i-1][j]))+1;
                }
            }
        }
        return f[m][n];

    }
}
