package codetop_byte.q0316;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val =val;
        }
    }
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        dfs(root,targetSum,new ArrayList<Integer>());

        return res;
    }

    private void dfs(TreeNode root,int target,List<Integer> curL) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (target == root.val) {
                curL.add(root.val);
                List<Integer> curList = new ArrayList<>(curL);
                res.add(curList);
                curL.remove(curL.size()-1);

            }
            return;
        }
        if(root.left != null) {
            target-=root.val;
            curL.add(root.val);
            dfs(root.left,target,curL);
            target+=root.val;
            curL.remove(curL.size()-1);
        }
        if (root.right != null) {
            target-=root.val;
            curL.add(root.val);
            dfs(root.right,target,curL);
            target+=root.val;
            curL.remove(curL.size()-1);
        }
    }
    @Test
    public void show () {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(11);
        TreeNode t5 = new TreeNode(13);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(2);
        TreeNode t9 = new TreeNode(5);
        TreeNode t10 = new TreeNode(1);


        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left= t5;
        t3.right = t6;
        t4.left = t7;
        t4.right = t8;
        t6.left = t9;
        t6.right = t10;
        System.out.println(pathSum(t1,22));
    }
}
