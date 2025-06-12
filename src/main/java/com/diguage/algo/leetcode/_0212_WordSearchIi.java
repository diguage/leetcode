package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0212_WordSearchIi {
  // tag::answer[]

  /**
   * 通过 43 / 65 个测试用例。超时！
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-12 22:53:03
   */
  int[][] options = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public List<String> findWords(char[][] board, String[] words) {
    Trie trie = new Trie();
    for (String word : words) {
      trie.insert(word);
    }
    Set<String> result = new HashSet<>();
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[r].length; c++) {
        dfs(board, r, c, trie, result);
      }
    }
    return new ArrayList<>(result);
  }

  private void dfs(char[][] board, int row, int col,
                   Trie trie, Set<String> result) {
    if (row < 0 || row >= board.length
      || col < 0 || col >= board[0].length) {
      return;
    }
    char letter = board[row][col];
    if (!trie.containsLetter(letter)) {
      return;
    }
    trie = trie.search(letter);
    if (trie.word != null) {
      result.add(trie.word);
    }
    board[row][col] = '#';
    for (int[] option : options) {
      int r = row + option[0];
      int c = col + option[1];
      dfs(board, r, c, trie, result);
    }
    board[row][col] = letter;
  }

  public static class Trie {
    Trie[] children = new Trie[26];
    String word;

    public void insert(String word) {
      Trie curr = this;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (curr.children[c - 'a'] == null) {
          curr.children[c - 'a'] = new Trie();
        }
        curr = curr.children[c - 'a'];
      }
      curr.word = word;
    }

    public boolean containsLetter(char letter) {
      int idx = letter - 'a';
      if (idx < 0 || idx >= children.length) {
        return false;
      }
      return children[idx] != null;
    }

    public Trie search(char letter) {
      return children[letter - 'a'];
    }
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0212_WordSearchIi().findWords(new char[][]{
        {'o', 'a', 'b', 'n'},
        {'o', 't', 'a', 'e'},
        {'a', 'h', 'k', 'r'},
        {'a', 'f', 'l', 'v'}},
      new String[]{"oa", "oaa"});
  }
}
