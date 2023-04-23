package codetop_byte.q0423;

public class GetTreeSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static final int MOD = (int) 1e9 + 7;

    public int getTreeSum(TreeNode tree) {
        // write code here
        if (tree == null) {
            return 0;
        }
        return (int) (dfs(tree) % MOD);
    }

    private long dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        long ans = 1;
        long l = dfs(root.left);
        long r = dfs(root.right);
        ans = (ans + Math.max(l, r) * 2);
        return ans;
    }
}
