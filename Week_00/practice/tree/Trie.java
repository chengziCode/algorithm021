package practice.tree;


// 208 实现前缀树 https://leetcode-cn.com/problems/implement-trie-prefix-tree/
public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.startsWith("app");
    }

    /**
     * Initialize your data structure here.
     */
    private boolean isEnd;
    private Trie[] next;

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
        for(Character ch : chars){
            int index = ch - 'a';
            if (cur.next[index] == null) cur.next[index] = new Trie();
            cur = cur.next[index];
        }
        cur.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }



    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String word) {
        if (word == null || word.length() == 0) return null;

        Trie cur = this;
        char[] chars = word.toCharArray();

        for(Character ch : chars){
            int index = ch - 'a';
            if(cur.next[index] == null) return null;
            else cur = cur.next[index];
        }
        return cur;
    }

}
