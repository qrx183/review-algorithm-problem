package codetop_byte.q0406;

import org.junit.jupiter.api.Test;

import java.util.*;

public class WidthOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        int ans = 1;
        int deep = 1;
        Map<TreeNode,Integer> map = new HashMap<>();
        map.put(root,0);
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();

            List<Integer> l = new ArrayList<>();
            while(size != 0) {
                TreeNode cur =q.poll();
                if(cur.left != null) {
                    map.put(cur.left,map.get(cur)*2);
                    l.add(map.get(cur)*2);
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    map.put(cur.right,map.get(cur)*2+1);
                    l.add(map.get(cur)*2+1);
                    q.offer(cur.right);
                }
                size --;
            }
            if (l.size() > 0) {
                ans = Math.max(ans,l.get(l.size()-1)-l.get(0)+1);
            }
        }
        return ans;
    }
    @Test
    public void show() {
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(1);
        TreeNode l3 = new TreeNode(1);
        TreeNode l4 = new TreeNode(1);
        TreeNode l5 = new TreeNode(1);
        TreeNode l6 = new TreeNode(1);
        l1.left = l2;
        l1.right = l3;
        l2.left = l4;
        l2.right = l5;
        l3.right = l6;
        System.out.println(widthOfBinaryTree(l1));
    }
}
