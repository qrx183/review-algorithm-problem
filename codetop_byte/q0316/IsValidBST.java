package codetop_byte.q0316;

public class IsValidBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public boolean isValidBST(TreeNode root) {
       if(root == null) {
           return true;
       }
       if (!isValidLeft(root,root.left) || !isValidRight(root,root.right)) {
           return false;
       }else{
           return isValidBST(root.left) && isValidBST(root.right);
       }
    }
    private boolean isValidLeft(TreeNode root,TreeNode child) {
        if(child == null) {
            return true;
        }
        if(root.val <= child.val) {
            return false;
        }else{
            return isValidLeft(root,child.left) && isValidLeft(root,child.right);
        }
    }
    private boolean isValidRight(TreeNode root,TreeNode child) {
        if(child == null) {
            return true;
        }
        if(root.val >= child.val) {
            return false;
        }else{
            return isValidRight(root,child.left) && isValidRight(root,child.right);
        }
    }



}
