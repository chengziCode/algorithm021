import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// 212 单词搜索II  https://leetcode-cn.com/problems/word-search-ii/
public class FindWords {
    public List<String> findWords(char[][] board, String[] words) {

        /**
         * 1 先把words生成字典树
         * 2 遍历board每个字符去字典树中查找。
         * 3 需要对board中的每个字符进行dfs搜索
         */

        HashSet<String> resSet = new HashSet<>();
        Trie trie = new Trie();
        for (String word : words) trie.insert(word);

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char ch = board[i][j];
                dfs(trie, board, i, j, resSet, visited);
            }
        }
        return new ArrayList<>(resSet);
    }

    private void dfs(Trie curNode, char[][] board, int i, int j, HashSet hashSet, boolean[][] visited) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || visited[i][j]) return;

        visited[i][j] = true;
        curNode = curNode.next[board[i][j] - 'a']; //拿到字符在字典中对应位置的值
        if (curNode == null) {//当前字母不在字典中，清除访问状态并返回
            visited[i][j] = false; //清除状态
            return;
        }
        if (curNode.isEnd) hashSet.add(curNode.val);//当前字母不为空，且是叶子节点，把对应的值加入到list

        dfs(curNode, board, i + 1, j, hashSet, visited);
        dfs(curNode, board, i - 1, j, hashSet, visited);
        dfs(curNode, board, i, j + 1, hashSet, visited);
        dfs(curNode, board, i, j - 1, hashSet, visited);

        visited[i][j] = false; //清除状态
    }


    class Trie {
        /**
         * Initialize your data structure here.
         */
        private boolean isEnd;
        private Trie[] next;
        private String val;

        public Trie() {
            isEnd = false;
            next = new Trie[26];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null || word.length() == 0) return;
            char[] chars = word.toCharArray();

            Trie cur = this;
            for (Character ch : chars) {
                int index = ch - 'a';
                if (cur.next[index] == null) cur.next[index] = new Trie();
                cur = cur.next[index];
            }
            cur.isEnd = true;
            cur.val = word;
        }
    }
}
