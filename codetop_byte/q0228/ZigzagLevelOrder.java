package codetop_byte.q0228;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {
    // 二叉树的层寻遍历变形
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty()) {
            List<Integer> curList = new ArrayList<>();
            int size = queue.size();
            while(size != 0) {
                TreeNode curNode = queue.poll();
                curList.add(curNode.val);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
                size--;
            }
            if(i%2==0){
                List<Integer> tempList = new ArrayList<>();
                for (int j = curList.size() - 1; j >= 0; j--) {
                    tempList.add(curList.get(j));
                }
                res.add(tempList);
            }else{
                res.add(curList);
            }
            i++;
        }
        return res;
    }
}
