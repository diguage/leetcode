package com.diguage.algo.leetcode;

public class _0720_LongestWordInDictionary {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-26 22:50:40
   */
  public String longestWord(String[] words) {
    Trie trie = new Trie();
    for (String word : words) {
      trie.insert(word);
    }
    String result = "";
    for (String word : words) {
      if (trie.search(word)) {
        if (word.length() > result.length()
          || (word.length() == result.length() && word.compareTo(result) < 0)) {
          result = word;
        }
      }
    }
    return result;
  }

  public static class Trie {
    private Trie[] children = new Trie[26];
    private boolean isWord = false;

    public void insert(String word) {
      Trie node = this;
      for (char c : word.toCharArray()) {
        int index = c - 'a';
        if (node.children[index] == null) {
          node.children[index] = new Trie();
        }
        node = node.children[index];
      }
      node.isWord = true;
    }

    public boolean search(String word) {
      Trie node = this;
      for (char c : word.toCharArray()) {
        int index = c - 'a';
        if (node.children[index] == null || !node.children[index].isWord) {
          return false;
        }
        node = node.children[index];
      }
      return node != null && node.isWord;
    }
  }
  // end::answer[]
}
