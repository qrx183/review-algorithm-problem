package codetop_byte.q0507;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodes {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            res += size;
            while(size != 0) {
                TreeNode curR = q.poll();
                if (curR.left != null) {
                    q.offer(curR.left);
                }
                if(curR.right != null) {
                    q.offer(curR.right);
                }
                size--;
            }
        }
        return res;
    }
}
