package com.diguage.algorithm.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * = 208. Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/[Implement Trie (Prefix Tree) - LeetCode]
 *
 * Implement a trie with `insert`, `search`, and `startsWith` methods.
 *
 * .Example:
 * [source,java]
 * ----
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * ----
 *
 * *Note:*
 *
 * * You may assume that all inputs are consist of lowercase letters `a-z`.
 * * All inputs are guaranteed to be non-empty strings.
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-26 19:47
 */
public class _0208_ImplementTriePrefixTree {
    /**
     * Runtime: 69 ms, faster than 11.59% of Java online submissions for Implement Trie (Prefix Tree).
     *
     * Memory Usage: 62.6 MB, less than 5.77% of Java online submissions for Implement Trie (Prefix Tree).
     */
    class Trie {
        private int ALPHABET_SIZE = 26;

        class TrieNode {
            private TrieNode[] alphabet;
            private boolean isEnd;

            public TrieNode() {
                this.alphabet = new TrieNode[ALPHABET_SIZE];
                Arrays.fill(this.alphabet, null);
                this.isEnd = false;
            }
        }

        private TrieNode[] root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            this.root = new TrieNode[ALPHABET_SIZE];
            Arrays.fill(this.root, null);
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            char[] chars = word.toCharArray();
            TrieNode[] current = this.root;
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (Objects.isNull(current[index])) {
                    current[index] = new TrieNode();
                }
                if (i == chars.length - 1) {
                    current[index].isEnd = true;
                }
                current = current[index].alphabet;
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            char[] chars = word.toCharArray();
            TrieNode[] current = this.root;
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (Objects.isNull(current[index])) {
                    return false;
                }
                if (i == chars.length - 1) {
                    return current[index].isEnd;
                }
                current = current[index].alphabet;
            }
            return false;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            TrieNode[] current = this.root;
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (Objects.isNull(current[index])) {
                    return false;
                }
                current = current[index].alphabet;
            }
            return true;
        }
    }

    private void test() {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(!trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    public static void main(String[] args) {
        _0208_ImplementTriePrefixTree solution = new _0208_ImplementTriePrefixTree();
        solution.test();
    }
}
