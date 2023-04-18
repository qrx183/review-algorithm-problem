package codetop_byte.q0418;

import java.util.Arrays;

public class Candy {
    public int candy (int[] arr) {
        // write code here
        int m = arr.length;
        int[] ans = new int[m];
        Arrays.fill(ans,1);
        for(int i = 1; i < m; i++) {
            if(arr[i] > arr[i-1]) {
                ans[i] = ans[i-1]+1;
            }
        }

        int res = ans[m-1];
        for(int i = m-2; i >= 0; i--) {
            if(arr[i] > arr[i+1] && ans[i] <= ans[i+1]){
                ans[i] = ans[i+1]+1;
            }
            res += ans[i];
        }
        return res;
    }

}
