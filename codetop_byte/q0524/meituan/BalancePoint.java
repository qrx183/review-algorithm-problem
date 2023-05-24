package codetop_byte.q0524.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BalancePoint {
    private static int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] colors = new char[n];
        String s = scanner.next();
        for(int i = 0; i < n; i++) {
            colors[i] = s.charAt(i);
        }
        List<Integer>[] nxs = new List[n];
        for(int i = 0; i < n; i++) {
            nxs[i] = new ArrayList<>();
        }
        for(int i = 1; i < n; i++) {
            int st = scanner.nextInt();
            nxs[st].add(i);
        }
        dfs(0,nxs,colors);
        System.out.println(res);
    }

    // 返回结果 a[0]表示子树的红色节点的个数,a[1]表示子树的蓝色节点的个数
    private static int[] dfs(int i,List<Integer>[] nxs,char[] colors) {
        if(nxs[i].size() == 0) {
            int rs = colors[i] == 'R' ? 1 : 0;
            int bs = colors[i] == 'B' ? 1 : 0;
            return new int[]{rs,bs};
        }
        int rs =  0;
        int bs =  0;
        for(int nx : nxs[i]) {
            int[] cs = dfs(nx,nxs,colors);
            rs += cs[0];
            bs += cs[1];
        }
        if(rs == bs && rs != 0) {
            res++ ;
        }
        rs = rs + (colors[i] == 'R' ? 1 : 0);
        bs = bs + (colors[i] == 'B' ? 1 : 0);
        return new int[]{rs,bs};
    }
}
