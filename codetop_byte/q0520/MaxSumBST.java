package codetop_byte.q0520;

public class MaxSumBST {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode (int val) {
            this.val = val;
        }
    }
    int ans = 0;
    // 二叉搜索树的判断不能单纯的判断当前节点和左子节点和右子节点的值,而是要保证左右子树分别是一棵二叉搜索树的前提下,去比较
    // 当前节点与左节点的最大值以及右节点的最小值
    // 所以返回结果里除了子树节点和外,还要包括子树是否是一棵二叉搜索树,左子树中的最大值和最小值
    // 特殊的,对于root==null的节点,其最大值和最小值的取值应该本着不影响其父亲节点是一棵二叉搜索树来赋值.
    // 因此最大值应该被赋成最小值,最小值应该被赋成最大值
    public int maxSumBST(TreeNode root) {
        if(root == null) {
            return 0;
        }
        dfs(root);
        return ans;
    }
    private int[] dfs(TreeNode root) {
        if(root == null) {
            ans = Math.max(ans,0);
            // true,sum,max,min
            return new int[]{1,0,-50000,50000};
        }
        if(root.left == null && root.right == null) {
            ans = Math.max(ans,root.val);
            return new int[]{1,root.val,root.val,root.val};
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int cur = root.val + l[1]+r[1];
        if(l[0] == 1 && r[0] == 1 && (root.left == null || root.val > l[2]) && (root.right == null || root.val < r[3])) {
            ans = Math.max(ans,cur);
            return new int[]{1,cur,Math.max(root.val,r[2]),Math.min(root.val,l[3])};
        }else{
            return new int[]{0,0,0,0};
        }
    }
}
