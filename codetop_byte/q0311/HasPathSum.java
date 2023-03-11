package codetop_byte.q0311;

import org.junit.jupiter.api.Test;

public class HasPathSum {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }
    boolean res = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return res;
        }
        dfs(root,targetSum);
        return res;
    }
    private void dfs(TreeNode root,int targetSum) {
        if (root == null) {
            if (targetSum == 0) {
                res = true;
            }
            return;
        }
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                res = true;
            }
            return;
        }
        if (root.left != null) {
            targetSum -= root.val;
            dfs(root.left,targetSum);
            targetSum += root.val;
        }
        if (root.right != null) {
            targetSum -= root.val;
            dfs(root.right,targetSum-root.right.val);
            targetSum += root.val;
        }


    }

    @Test
    public void show() {
        TreeNode l1= new TreeNode(5);
        TreeNode l2= new TreeNode(4);
        TreeNode l3= new TreeNode(11);
        TreeNode l4= new TreeNode(7);
        TreeNode l5= new TreeNode(2);
        l1.left = l2;
        l2.left = l3;
        l3.left = l4;
        l3.right = l5;
        System.out.println(hasPathSum(l1,22));
    }
}
