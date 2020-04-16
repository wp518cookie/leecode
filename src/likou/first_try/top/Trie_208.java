package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-04-13
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */

public class Trie_208 {
    private Node[] node;

    private static class Node {
        Node[] t = new Node[26];
        boolean flag = false;

        public Node() {

        }
    }

    /** Initialize your data structure here. */
    public Trie_208() {
        node = new Node[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (node[word.charAt(0) - 97] == null) {
            node[word.charAt(0) - 97] = new Node();
            if (word.length() == 1) {
                node[word.charAt(0) - 97].flag = true;
                return;
            }
        }
        insert(node[word.charAt(0) - 97], word, 1);
    }

    private void insert(Node n, String word, int d) {
        if (d >= word.length()) {
            return;
        }
        int idx = word.charAt(d) - 97;
        if (n.t[idx] == null) {
            n.t[idx] = new Node();
        }
        if (d == word.length() - 1) {
            n.t[idx].flag = true;
            return;
        }
        insert(n.t[idx], word, d + 1);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int idx = word.charAt(0) - 97;
        if (node[idx] == null) {
            return false;
        }
        if (word.length() == 1) {
            return node[idx].flag;
        }
        return search(node[idx], word, 1);
    }

    private boolean search(Node n, String word, int d) {
        int idx = word.charAt(d) - 97;
        if (n.t[idx] == null) {
            return false;
        }
        if (d == word.length() - 1) {
            return n.t[idx].flag;
        }
        return search(n.t[idx], word, d + 1);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int idx = prefix.charAt(0) - 97;
        if (node[idx] == null) {
            return false;
        }
        if (prefix.length() == 1) {
            return true;
        }

        return startsWith(node[idx], prefix, 1);
    }

    private boolean startsWith(Node n, String prefix, int d) {
        int idx = prefix.charAt(d) - 97;
        if (n.t[idx] == null) {
            return false;
        }
        if (d == prefix.length() - 1) {
            return true;
        }
        return startsWith(n.t[idx], prefix, d + 1);
    }
}
