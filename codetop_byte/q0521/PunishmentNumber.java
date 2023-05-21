package codetop_byte.q0521;

import org.junit.jupiter.api.Test;

public class PunishmentNumber {
    boolean isValid = false;
    public int punishmentNumber(int n) {
        if(n == 1) {
            return 1;
        }
        int res = 0;
        for(int i = 1; i <= n; i++) {
            String s = String.valueOf(i*i);
            dfs(s,i,0);
            if(isValid) {
                res += i * i;
            }
            isValid = false;
        }
        return res;
    }
    private int dfs(String s,int target,int index) {
        if(index == s.length() && target == 0){
            isValid = true;
        }
        if(isValid) {
            return 0;
        }
        if(index >= s.length()) {
            return 0;
        }
        for(int i = index; i < s.length(); i++) {
            int num = Integer.parseInt(s.substring(index,i+1));
            dfs(s,target-num,i+1);
        }

        return 0;
    }
    @Test
    public void show() {
        System.out.println(punishmentNumber(10));
    }
}
