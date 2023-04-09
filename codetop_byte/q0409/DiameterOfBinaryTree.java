package codetop_byte.q0409;

import org.junit.jupiter.api.Test;

public class DiameterOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode p){
        if(p == null){
            return 0;
        }
        if(p.left == null && p.right == null){
            return 1;
        }
        int leftL = dfs(p.left);
        int rightL = dfs(p.right);
        ans = Math.max(ans,leftL+rightL);

        return Math.max(leftL,rightL) + 1;
    }
    @Test
    public void show() {
        TreeNode l1 = new TreeNode(4);
        TreeNode l2 = new TreeNode(7);
        TreeNode l3 = new TreeNode(-3);
        TreeNode l4 = new TreeNode(-9);
        TreeNode l5 = new TreeNode(-3);
        TreeNode l6 = new TreeNode(9);
        TreeNode l7 = new TreeNode(-7);
        TreeNode l8 = new TreeNode(-4);
        TreeNode l9 = new TreeNode(6);
        TreeNode l10 = new TreeNode(-6);
        TreeNode l11 = new TreeNode(-6);
        TreeNode l12 = new TreeNode(0);
        TreeNode l13 = new TreeNode(6);
        TreeNode l14 = new TreeNode(5);
        TreeNode l15 = new TreeNode(9);
        TreeNode l16 = new TreeNode(-1);
        TreeNode l17 = new TreeNode(-4);
        TreeNode l18 = new TreeNode(-2);
        l1.left = l2;
        l1.right = l3;
        l3.left = l4;
        l3.right = l5;
        l4.left = l6;
        l4.right = l7;
        l5.left = l8;
        l6.left = l9;
        l7.left = l10;
        l7.right = l11;
        l9.left = l12;
        l9.right = l13;
        l10.left = l14;
        l11.left = l15;
        l12.right = l16;
        l13.left = l17;
        l16.left = l18;
        System.out.println(diameterOfBinaryTree(l1));


    }
}
