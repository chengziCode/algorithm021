package practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// 102 二叉树的层序遍历 https://leetcode-cn.com/problems/binary-tree-level-order-traversal/submissions/

public class LevelOrder {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List resList = new ArrayList<List<Integer>>();
        if (root == null) return resList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> curList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                curList.add(treeNode.val);
                if (treeNode.left != null) queue.add(treeNode.left);
                if (treeNode.right != null) queue.add(treeNode.right);
            }
            resList.add(curList);
        }
        return resList;
    }


    public class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int x) {
            this.val = x;
        }
    }
}