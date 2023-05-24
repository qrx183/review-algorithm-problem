package codetop_byte.q0523;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StoreWater {
    public int storeWater(int[] bucket, int[] vat) {
        // 想法没错,先升级桶,然后再满
        int n = bucket.length;
        int maxk = Arrays.stream(vat).max().getAsInt();
        if (maxk == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int k = 1; k <= maxk && k < res; ++k) {
            int t = 0;
            for (int i = 0; i < bucket.length; ++i) {
                t += Math.max(0, (vat[i] + k - 1) / k - bucket[i]);
            }
            res = Math.min(res, t + k);
        }
        return res;
    }
    @Test
    public void show() {
        int[] b = {1,3};
        int[] v = {6,8};
        System.out.println(storeWater(b,v));
    }
}
