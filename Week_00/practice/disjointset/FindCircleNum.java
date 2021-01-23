package practice.disjointset;

//547 省份的数量 https://leetcode-cn.com/problems/number-of-provinces/
public class FindCircleNum {


    public int findCircleNum(int[][] isConnected) {

        int rows = isConnected.length;
        UnionFind unionFind = new UnionFind(rows);
        for (int i = 0; i < rows - 1; i++) {
            for (int j = i + 1; j < rows; j++) {
                if (isConnected[i][j] == 1) unionFind.union(i , j);
            }
        }
        return unionFind.count;
    }


    /**
     * 并查集模板代码
     */
    class UnionFind {
        private int count = 0;
        private int[] parent;

        public UnionFind(int size) {
            count = size;
            parent = new int[size];
            for (int i = 0; i < size; i++) parent[i] = i;
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]]; //压缩 : 指向上一个节点
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootQ] = parent[rootP];
            count--;
        }


    }

}
