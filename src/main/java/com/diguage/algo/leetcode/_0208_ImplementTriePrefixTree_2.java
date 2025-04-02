package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0208_ImplementTriePrefixTree_2 {
  // tag::answer[]

  /**
   * 没想到竟然一次通过，😁
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-02 19:42:48
   */
  class Trie {
    private Map<Character, Node> trie;

    public Trie() {
      trie = new HashMap<>();
    }

    public void insert(String word) {
      Map<Character, Node> curr = trie;
      Node node = null;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        node = curr.get(c);
        if (node == null) {
          node = new Node(c);
          curr.put(c, node);
        }
        curr = node.children;
      }
      node.isEnd = true;
    }

    public boolean search(String word) {
      Node node = searchPrefix(word);
      return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
      return searchPrefix(prefix) != null;
    }

    private Node searchPrefix(String word) {
      Map<Character, Node> curr = trie;
      Node node = null;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        node = curr.get(c);
        if (node == null) {
          return null;
        }
        curr = node.children;
      }
      return node;
    }

    private static class Node {
      char data;
      boolean isEnd;
      Map<Character, Node> children = new HashMap<>();

      public Node(char data) {
        this.data = data;
      }
    }
  }
  // end::answer[]
}
