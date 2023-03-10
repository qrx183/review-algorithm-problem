package codetop_byte.q0310;

public class IsSymmetric {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }
    boolean res = true;
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        dfs(root.left,root.right);
        return res;

    }
    private void dfs(TreeNode l,TreeNode r) {
        if ((l == null && r != null) || (l != null && r == null)) {
            res = false;
            return;
        }
        if (l == null && r == null) {
            return;
        }
        if (l.val != r.val) {
            res = false;
            return;
        }
        dfs(l.left,r.right);
        dfs(l.right,r.left);
    }
}
