package practice.tree;

import java.util.*;

/**
 * 429 N叉树的中层遍历 https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 *
 *
 * 总结：  这题用递归比迭代麻烦的地方在于，递归需要维护一个和层数映射的map用于收集多个系统栈的数据。
 *      而迭代方便的地方在于，每次只需要把下一次要访问的节点放到队列中，然后进行循环，就可以保证最外层
 *      的循环可以把一层的所有节点都访问到，作为一层写入一个list中。
 *
 */
public class BreadthFirstSearchNTree {

    /**
     * 迭代 bfs
     *
     * 思路： 每次都把下一次需要访问的节点都放入队列中
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderByIteration(Node root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> resList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                curLevel.add(node.val);
                queue.addAll(node.children);
            }
            resList.add(curLevel);
        }
        return resList;
    }

    /**
     * 429 递归 bfs
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderByRecursion(Node root) {
        if (root == null)
            return new ArrayList<>();

        //initialize
        List<List<Integer>> resList = new ArrayList<>();
        LinkedHashMap<Integer, List<Integer>> linkedHashMap = new LinkedHashMap<>();
        resList.add(Arrays.asList(root.val));

        bfsByRecursion(root, 1, linkedHashMap);

        //move to list from hashMap
        for (Map.Entry<Integer, List<Integer>> entry : linkedHashMap.entrySet()) resList.add(entry.getValue());

        return resList;
    }

    /**
     * @param root
     * @param level         层数
     * @param linkedHashMap 层数, 对应的当前层数的list
     */
    private void bfsByRecursion(Node root, int level, LinkedHashMap<Integer, List<Integer>> linkedHashMap) {
        //recurtion terminator
        if (root == null) return;

        for (Node childNode : root.children) {
            if (childNode == null) continue;

            // process
            List<Integer> list = linkedHashMap.getOrDefault(level, new ArrayList<Integer>());
            list.add(childNode.val);
            linkedHashMap.put(level, list);

            //drill down
            bfsByRecursion(childNode, level + 1, linkedHashMap);
        }
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
