package codetop_byte.q0521.ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FullChildTree {
    private static List<Integer>[] nxs;
    private static int n;
    private static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        nxs = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            nxs[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            nxs[i].add(l);
            nxs[i].add(r);
        }
        dfs(1);
        System.out.println(res);
    }

    // 返回结果a[i]:a[0]表示是否是满二叉树,a[1]表示左子树的高度,a[2]表示右子树的高度
    private static int[] dfs(int index) {
        if (nxs[index].get(0) == -1 && nxs[index].get(1) == -1) {
            res++;
            return new int[]{1, 1};
        }
        List<Integer> list = nxs[index];
        int[] l = new int[]{0, 0};
        int[] r = new int[]{0, 0};
        if (list.get(0) != -1) {
            l = dfs(list.get(0));
        }
        if (list.get(1) != -1) {
            r = dfs(list.get(1));
        }
        if (l[0] == 1 && r[0] == 1 && l[1] == r[1]) {
            res++;
            return new int[]{1, 1 + l[1]};
        } else {
            return new int[]{0, 1 + Math.max(l[1], r[1])};
        }

    }
}
