package com.sakuya.leetcode.week07;

/**
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
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Normal208 {
    class Trie {
        class TreeNode {

            private final static int size = 26;

            private TreeNode[] links;
            private boolean end;

            TreeNode() {
                links = new TreeNode[26];
            }

            public boolean contains(char ch) {
                return links[ch - 'a'] != null;
            }

            public TreeNode get(char ch) {
                return links[ch - 'a'];
            }

            public void set(char ch, TreeNode treeNode) {
                links[ch - 'a'] = treeNode;
            }

            public void setEnd(boolean end) {
                this.end = end;
            }

            public boolean isEnd() {
                return end;
            }
        }

        private TreeNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TreeNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TreeNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.contains(ch)) {
                    node.set(ch, new TreeNode());
                }
                node = node.get(ch);
            }
            node.setEnd(true);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TreeNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.contains(ch)) return false;
                node = node.get(ch);
            }
            return node.isEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TreeNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if (!node.contains(ch)) return false;
                node = node.get(ch);
            }
            return true;
        }
    }

}
