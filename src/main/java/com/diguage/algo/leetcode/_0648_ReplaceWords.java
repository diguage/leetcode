package com.diguage.algo.leetcode;

import java.util.List;

public class _0648_ReplaceWords {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-19 20:46:30
   */
  public String replaceWords(List<String> dictionary, String sentence) {
    Trie root = new Trie();
    for (String word : dictionary) {
      root.add(word);
    }
    String[] words = sentence.split(" ");
    for (int i = 0; i < words.length; i++) {
      words[i] = root.find(words[i]);
    }
    return String.join(" ", words);
  }

  public static class Trie {
    Trie[] nodes = new Trie[26];
    boolean end = false;

    public void add(String word) {
      Trie[] curr = nodes;
      Trie trie = null;
      for (char c : word.toCharArray()) {
        int idx = c - 'a';
        trie = curr[idx];
        if (trie == null) {
          curr[idx] = new Trie();
          trie = curr[idx];
        }
        curr = trie.nodes;
      }
      trie.end = true;
    }

    public String find(String word) {
      Trie[] curr = nodes;
      StringBuilder sb = new StringBuilder();
      for (char c : word.toCharArray()) {
        int idx = c - 'a';
        Trie trie = curr[idx];
        if (trie == null) {
          break;
        }
        sb.append(c);
        if (trie.end) {
          return sb.toString();
        }
        curr = trie.nodes;
      }
      return word;
    }
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0648_ReplaceWords()
      .replaceWords(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery");
  }
}
