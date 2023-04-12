package codetop_byte.q0412;

public class IsMatch {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 2; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                f[0][i] = f[0][i - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (sc == pc || pc == '.') {
                    f[i][j] = f[i - 1][j - 1];
                } else if (pc == '*' && j >= 2) {
                    f[i][j] = f[i][j - 2];
                    if (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                }
            }
        }
        return f[m][n];
    }
}
