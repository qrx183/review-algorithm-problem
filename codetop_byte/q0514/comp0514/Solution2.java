package codetop_byte.q0514.comp0514;

public class Solution2 {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] ori = new int[n];
        for(int i = 1; i < n; i++) {
            if(derived[i-1] == 1) {
                ori[i] = (ori[i-1]+1) % 2;
            }else{
                ori[i] = ori[i-1];
            }
        }
        return (ori[n-1] ^ ori[0]) == derived[n-1];
    }
}
