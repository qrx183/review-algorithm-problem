package codetop_byte.q0422;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class GetBinaryTrees {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    int m;
    boolean[] isV;
    ArrayList<TreeNode> res;

    public ArrayList<TreeNode> getBinaryTrees(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        // write code here
        // 带有重复节点的前序中序二叉树
        // 按照传统的不重复的前序中序二叉树的方式递归很难得到数组.

        // 这道题的思路:首先你递归的返回结果应该是一个数组,因为value可重复意味着任何一个节点的左右子树可以组成不同的结果
        // 因此递归的返回结果应该返回一个以该节点为根节点,左右子树任意组合得到的节点数组
        // 如何保证值相同的节点不会被重复遍历:通过控制前序序列遍历的区域[preL,preR]以及中序序列可遍历的区域[inL,inR]

        // 因此整个思路:1.递归获取该节点左子树符合条件的所有节点数组和右子树符合条件的所有节点数组.然后通过组合获取到该节点的节点数组并返回
        // 同时在递归的过程中通过参数来控制前序和中序可遍历的区域
        return dfs(preOrder,inOrder,0,preOrder.size()-1,0,inOrder.size()-1);
    }

   private ArrayList<TreeNode> dfs(ArrayList<Integer> preOrder,ArrayList<Integer> inOrder,int pl,int pr,int il,int ir) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if(pl > pr || il > ir) {
            res.add(null);
            return res;
        }
        for(int i = il;i <= ir; i++) {
            if(inOrder.get(i) == preOrder.get(pl)) {
                ArrayList<TreeNode> lRes = dfs(preOrder,inOrder,pl+1,pl+i-il,il,i-1);
                ArrayList<TreeNode> rRes = dfs(preOrder,inOrder,pl+i-il+1,pr,i+1,ir);
                for(TreeNode left:lRes) {
                    for(TreeNode right: rRes) {
                        TreeNode root = new TreeNode(preOrder.get(pl));
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
       }
        return res;
   }
    private int getIndex2(ArrayList<Integer> inOrder,int key) {
        for(int i = 0; i < inOrder.size(); i++) {
            if(!isV[i] && inOrder.get(i) == key) {
                return i;
            }
        }
        return -1;
    }
    private ArrayList<Integer> getIndex(ArrayList<Integer> inOrder, int key) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < inOrder.size(); i++) {
            if (!isV[i] && inOrder.get(i) == key) {
                ans.add(i);
            }
        }
        return ans;
    }

    @Test
    public void show() {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        l1.add(1);
        l1.add(1);
        l1.add(2);
        l2.add(1);
        l2.add(2);
        l2.add(1);
        System.out.println(getBinaryTrees(l1, l2));

    }
}
