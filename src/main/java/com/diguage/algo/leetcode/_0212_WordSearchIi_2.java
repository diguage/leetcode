package com.diguage.algo.leetcode;

import java.util.*;

public class _0212_WordSearchIi_2 {
  // tag::answer[]

  /**
   * 回溯（63/65）-> 前缀树+回溯（65.92%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-01 22:18:24
   */
  public List<String> findWords(char[][] board, String[] words) {
    Set<String> result = new HashSet<>();
    Trie trie = new Trie();
    for (String word : words) {
      trie.addWord(word);
    }
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[r].length; c++) {
        backtrack(board, r, c, trie, result);
      }
    }

    return new ArrayList<>(result);
  }

  private boolean backtrack(char[][] board, int row, int column,
                            Trie trie, Set<String> result) {
    if (row < 0 || row >= board.length
      || column < 0 || column >= board[row].length
      || board[row][column] == '.'
      || trie.tree[board[row][column] - 'a'] == null) {
      return false;
    }
    char c = board[row][column];
    board[row][column] = '.';
    Trie curr = trie.tree[c - 'a'];
    if (curr.isEnd) {
      result.add(curr.word);
    }
    boolean r = // 上
      backtrack(board, row - 1, column, curr, result)
        // 下
        || backtrack(board, row + 1, column, curr, result)
        // 左
        || backtrack(board, row, column - 1, curr, result)
        // 右
        || backtrack(board, row, column + 1, curr, result);
    board[row][column] = c;
    return r;
  }

  public static class Trie {
    Trie[] tree;
    boolean isEnd;
    String word;

    Trie() {
      tree = new Trie[26];
    }

    Trie(String word) {
      tree = new Trie[26];
      addWord(word);
    }

    public void addWord(String word) {
      Trie[] temp = tree;
      char[] chars = word.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        char c = chars[i];
        Trie curr = temp[c - 'a'];
        if (Objects.isNull(curr)) {
          curr = new Trie();
          temp[c - 'a'] = curr;
        }
        if (i == chars.length - 1) {
          curr.isEnd = true;
          curr.word = word;
        }
        temp = curr.tree;
      }
    }
  }
  // end::answer[]

  static void main() {
    new _0212_WordSearchIi_2().findWords(new char[0][0], new String[]{"oath", "pea", "eat", "rain"});
  }
}
