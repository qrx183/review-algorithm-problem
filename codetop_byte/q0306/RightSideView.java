package codetop_byte.q0306;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> curL = new ArrayList<>();
            int size = q.size();
            while(size != 0) {
                TreeNode r = q.poll();
                curL.add(r.val);
                if (r.left != null) {
                    q.offer(r.left);
                }
                if (r.right != null) {
                    q.offer(r.right);
                }
                size--;
            }
            res.add(curL.get(curL.size()-1));
        }
        return res;
    }
}
