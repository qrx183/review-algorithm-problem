package codetop_byte.q0512.meituan;

import java.util.*;

public class Value {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] f = new int[n+1];
        List<Integer>[] paToCh = new List[n+1];
        int[] colors = new int[n+1];
        for(int i = 1; i <= n; i++) {
            paToCh[i] = new ArrayList<>();
        }
        for(int i = 2; i <= n; i++) {
            int pi = scanner.nextInt();
            paToCh[pi].add(i);
        }
        for(int i = 1; i <= n; i++) {
            colors[i] = scanner.nextInt();
        }
        for(int i = n; i >= 1; i--) {
            if(paToCh[i].size() == 0) {
                f[i] = 1;
            }else{
                int l = paToCh[i].get(0);
                int r = paToCh[i].get(1);
                if(colors[i] == 1) {
                    f[i] = f[l]+f[r];
                }else{
                    f[i] = f[l] ^ f[r];
                }
            }
        }
        System.out.println(f[1]);
    }
}
