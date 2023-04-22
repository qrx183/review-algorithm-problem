package codetop_byte.q0422;

public class MinOperations {
    public int minOperations (String str) {
        // write code here
        int m = str.length();
        if(m <= 1) {
            return 0;
        }
        int[][] f = new int[m+1][2];
        f[1][0] = str.charAt(0) == '0' ? 0 : 1;
        f[1][1] = str.charAt(0) == '1' ? 0 : 1;
        for(int i = 2; i <= m; i++) {
            char ch = str.charAt(i-1);
            if(ch == '0') {
                f[i][0] = f[i-1][0];
                f[i][1] = Math.min(f[i-1][1],f[i-2][1])+1;
            }else if(ch == '1'){
                f[i][1] = f[i-1][1];
                f[i][0] = Math.min(f[i-1][0],f[i-2][0])+1;
            }
        }
        return Math.min(f[m][0],f[m][1]);
    }
}
