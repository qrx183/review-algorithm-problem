package codetop_byte.q0420;

import java.util.Scanner;

public class OptimalBinaryTree {
    // 最优二叉树:中序遍历不确定,求最小权值
    // 中序遍历的特点:对于任意一个节点,其左边所有节点组成该节点的左子树,其右边所有节点组成该节点的右子树(即使有些情况可能不满足树的结构本身)
    // 但最终的结果是一样的
    // l[a][b] 表示 以node[b+1]作为根节点,区间[a-b]作为左子树的最优权值
    // r[a][b] 表示 以node[a-1]作为根节点,区间[a-b]作为右子树的最优权值
    // l[a][b] = min(l[a][b],l[a][i-1]+val[i]*val[b+1]+r[i+1][b])
    // r[a][b] = min(r[a][b],r[a][i-1]+val[i]*val[a-1]+r[i+1][b])
    static int[][] l = new int[302][302];
    static int[][] r = new int[302][302];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] node = new int[n+2];
        for(int i = 1; i <= n; i++) {
            node[i] = scanner.nextInt();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= n-i; j++) {
                dp(j,j+i,node);
            }
        }
        System.out.println(Math.min(l[1][n],r[1][n]));
    }
    private static void dp(int a,int b,int[] node) {
        l[a][b] = r[a][b] = 0x3fffffff;
        for(int i = a; i <= b; i++) {
            int x = l[a][i-1]+node[i]*node[b+1]+r[i+1][b];
            int y = l[a][i-1]+node[i]*node[a-1]+r[i+1][b];
            l[a][b] = Math.min(l[a][b],x);
            r[a][b] = Math.min(r[a][b],y);
        }
    }
}
