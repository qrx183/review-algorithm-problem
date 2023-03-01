package codetop_byte.q0301;

public class LowestCommonAncestor {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null) {
            return root;
        }else if (left != null){
            return left;
        }else {
            return right;
        }
    }
}
