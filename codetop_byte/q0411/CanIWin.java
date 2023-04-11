package codetop_byte.q0411;

public class CanIWin {
//    int[][] f;
//
//    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
//        // f[i][0]:剩余i时先手是否能赢,f[i][1]:剩余i时后手是否能赢
//        f = new int[desiredTotal+1][2];
//        return dfs(desiredTotal,maxChoosableInteger,0) == 1;
//    }
//
//    private int dfs(int total,int max,int step) {
//        if (total - max <= 0) {
//            f[total][step] = 1;
//            return 1;
//        }
//        if (f[total][step] != 0) {
//            return f[total][step];
//        }
//
//    }
    int m;
    Boolean[] dp;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal <= maxChoosableInteger){
            return true;
        }
        if((1+maxChoosableInteger)*maxChoosableInteger/2 < desiredTotal){
            return false;
        }
        m =  maxChoosableInteger;
        dp = new Boolean[1<<m];
        return dfs(desiredTotal,0);
    }
    public boolean dfs(int d,int state){
        if(dp[state] != null){
            return dp[state];
        }
        for(int i = 1; i <= m; i++){
            int cur = 1 << (i-1);
            if(((state >> (i-1))&1) == 0){
                // 状压dp表示选取了那些数字:1001(表示选取了1和4)
                if(d - i <= 0 || !dfs(d-i,state|cur)){
                    return dp[state] = true;
                }
            }
        }
        return dp[state] = false;
    }
}
