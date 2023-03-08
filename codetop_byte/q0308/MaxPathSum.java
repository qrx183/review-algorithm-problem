package codetop_byte.q0308;

public class MaxPathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val){
            this.val= val;
        }
    }
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int l = Math.max(0,dfs(root.left));
        int r = Math.max(0,dfs(root.right));
        ans = Math.max(ans,l+r+root.val);
        return root.val + Math.max(l,r);
    }
}
