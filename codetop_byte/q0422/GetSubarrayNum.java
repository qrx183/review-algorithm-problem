package codetop_byte.q0422;

import java.util.ArrayList;

public class GetSubarrayNum {

    // 连续子数组数量:子数组元素乘积末尾0的个数取决于:每个数的质因子2和质因子5的个数

    public static int MOD = (int)1e9+7;
    public int getSubarrayNum (ArrayList<Integer> a, int x) {
        // write code here
       int res = 0;
       int n = a.size();
       int[] five = new int[n];
       int[] two = new int[n];

       for(int i = 0; i < n; i++) {
           int val = a.get(i);
           while(val % 5 == 0 && val >= 5) {
               five[i]++;
               val/=5;
           }
           val = a.get(i);
           while(val % 2 == 0 && val >= 2) {
               two[i]++;
               val/=2;
           }
       }
       int l = 0,val1 = two[0],val2 = five[0];
       int r = 0;
       while(l < n) {
           while(r+1<n && Math.min(val1,val2) < x) {
               r++;
               val1 += two[r];
               val2 += five[r];
           }
           if(Math.min(val1,val2) >= x) {
               res = (res + n-r)%MOD;
           }
           val1-=two[l];
           val2-=five[l];
           l++;
       }
       return res;
    }

}
