package codetop_byte.q0510.ali;

import java.util.Scanner;

public class KGoodNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for(int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int k = scanner.nextInt();
            int ll = getNum(l,k);
            int rr = getNum(r,k);

            if(getK(Integer.toBinaryString(ll),k) > r) {
                System.out.println(0);
                continue;
            }
            int res = rr - ll + 1;
            if(getK(Integer.toBinaryString(rr),k) > r) {
                res -= 1;
            }
            System.out.println(res);
        }
    }
    private static int getNum(int num,int k) {
        long l = 0,r = (long)Math.pow(10,12);
        while(l < r) {
            long mid = l + r >> 1;
            if(getK(Long.toBinaryString(mid),k) >= num) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return (int)l;
    }

    private static long getK(String s,int k) {
        StringBuilder sb = new StringBuilder(s).reverse();
        s = new String(sb);
        long num = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                num += (long)Math.pow(k,i);
                if(num > (long)Math.pow(10,12)){
                    return (long)Math.pow(10,12);
                }
            }
        }
        return num;
    }
}
