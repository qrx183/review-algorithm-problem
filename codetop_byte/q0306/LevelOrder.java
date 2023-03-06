package codetop_byte.q0306;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null ){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> curL = new ArrayList<>();
            int size = q.size();
            while(size != 0) {
                TreeNode cur = q.poll();
                curL.add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                size--;
            }
            res.add(curL);
        }
        return res;
    }
}
