package practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * 144 前序遍历树 https://leetcode-cn.com/problems/binary-tree-preorder-traversal/submissions/
 * 94  中序遍历树   https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class TraversalBinaryTree {


    /**
     * 前后后遍历 二叉树 - 递归法
     * @param root
     * @return
     */
    public List<Integer> traversalTreeByRecursion(TreeNode root) {

        List<Integer> resList = new ArrayList<>();
        predfs(root, resList);
        return resList;
    }


    /**
     * 前序遍历 二叉树 - 迭代法（通过手动维护栈来实现）
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalByIteration(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        List<Integer> resList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode head = stack.pop();
            resList.add(head.val);
            if (head.right != null) stack.push(head.right);
            if (head.left != null) stack.push(head.left);
        }

        return resList;
    }

    /**
     * 前序遍历 二叉树 - 递归法（利用系统栈来实现）
     *
     * @param root
     * @param resList
     */
    private void predfs(TreeNode root, List<Integer> resList) {
        // recursion terminator
        if (root == null) return;

        //process
        resList.add(root.val);

        //drill down
        predfs(root.left, resList);
        predfs(root.right, resList);
    }


    /**
     * 中序遍历 二叉树
     *
     * @param root
     * @param resList
     */
    private void indfs(TreeNode root, List<Integer> resList) {
        // recursion terminator
        if (root == null) return;

        indfs(root.left, resList);
        resList.add(root.val);
        indfs(root.right, resList);
    }

    /**
     * 后序遍历 二叉树
     *
     * @param root
     * @param resList
     */
    private void postdfs(TreeNode root, List<Integer> resList) {
        // recursion terminator
        if (root == null) return;

        postdfs(root.left, resList);
        postdfs(root.right, resList);
        resList.add(root.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


