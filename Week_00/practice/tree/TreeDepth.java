package practice.tree;


// 104 树的深度最大 https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
// 111 二叉树的最小深度 https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
public class TreeDepth {

    /**
     * 104 最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int depth = dfs(0, root);
        return depth;
    }

    private int dfs(int depth, TreeNode root) {
        //termin
        if (root == null) return depth;

        //process and drill down
        depth++;
        int leftDepth = dfs(depth, root.left);
        int rightDepth = dfs(depth, root.right);
        return Math.max(leftDepth, rightDepth);
    }


    /**
     * 111 树的子节点最小深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        // recursion treminator
        if(root == null) return 0;

        //process drill down
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        //只要有个孩子节点为null，那么对应深度就为0，相加不会产生影响，简化了代码逻辑，不需要判断具体哪一个孩子节点为null
        if(root.left == null || root.right == null) return leftDepth + rightDepth + 1;
        else return Math.min(leftDepth,rightDepth) + 1;
    }

    /**
     * node
     */
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
