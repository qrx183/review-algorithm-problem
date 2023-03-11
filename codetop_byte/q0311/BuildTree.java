package codetop_byte.q0311;

public class BuildTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,preorder.length-1);
    }
    private TreeNode buildTree(int[] preorder,int[] inorder,int l,int r) {
        if (l > r) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int i = getIndexOfInorder(inorder,l,r,preorder[index]);
        if (i == -1) {
            return null;
        }
        index++;
        root.left = buildTree(preorder,inorder,l,i-1);
        root.right = buildTree(preorder,inorder,i+1,r);
        return root;
    }

    private int getIndexOfInorder(int[] inorder,int l,int r,int key) {
        for(int i = l; i <= r; i++) {
            if (inorder[i]== key) {
                return i;
            }
        }
        return -1;
    }
}
