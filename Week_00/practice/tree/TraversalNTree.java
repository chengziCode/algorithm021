package practice.tree;

import java.util.*;

/**
 * 589 N叉树的前序遍历 https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */

public class TraversalNTree {

    /**
     * 589 前序遍历 N叉树 - 递归法
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> resList = new ArrayList<>();
        preDfsByRecursion(root, resList);
        return resList;
    }


    /**
     * 589 前序遍历 N叉树 - 迭代法
     * 递归遍历树用的是系统栈， 而迭代遍历树需要自己维护一个栈
     */
    public List<Integer> preorderByIteration(Node root) {
        if (root == null) return new ArrayList<Integer>();

        List<Integer> resList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node head = stack.pop();
            resList.add(head.val);

            List<Node> childrenList = head.children;
            for (int i = childrenList.size() - 1; i >= 0; i--) {
                Node node = childrenList.get(i);
                if (node != null) stack.push(node);
            }
        }

        return resList;
    }

    /**
     * 递归 前序遍历N叉树
     *
     * @param root
     * @param resList
     */
    private void preDfsByRecursion(Node root, List<Integer> resList) {
        // recursion terminator
        if (root == null) return;
        // process
        resList.add(root.val);
        for (Node node : root.children)
            preDfsByRecursion(node, resList);//drill down
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


}


