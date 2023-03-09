package codetop_byte.q0309;

public class SumNumbers {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return ans;
        }
        dfs(root,root.val);
        return ans;
    }

    private int dfs(TreeNode root,int val) {
        if (root.left == null && root.right == null) {
            ans += val;
            return val;
        }
        if (root.left != null) {
            dfs(root.left,val*10 + root.left.val);
        }
       if (root.right != null) {
           dfs(root.right,val*10 +root.right.val);
       }

        return val;
    }
}
