package com.diguage.algo.leetcode;

public class _0079_WordSearch_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-15 08:52:34
   */
  public boolean exist(char[][] board, String word) {
    // 优化一：检查字母出现次数
    char[] counter = new char[52];
    for (char[] chars : board) {
      for (char c : chars) {
        counter[getIndex(c)]++;
      }
    }
    char[] cnt = new char[52];
    for (char c : word.toCharArray()) {
      cnt[getIndex(c)]++;
    }
    for (int i = 0; i < cnt.length; i++) {
      if (cnt[i] > counter[i]) {
        return false;
      }
    }

    // 优化二：如果最后字符出现次数更小，则从它开始，回溯次数更少
    int ti = getIndex(word.charAt(word.length() - 1));
    int hi = getIndex(word.charAt(0));
    if (cnt[ti] < cnt[hi]) {
      word = new StringBuilder(word).reverse().toString();
    }

    // 回溯查找
    for (int c = 0; c < board.length; c++) {
      for (int r = 0; r < board[c].length; r++) {
        boolean found = backtrack(board, c, r, word, 0);
        if (found) {
          return true;
        }
      }
    }
    return false;
  }

  private int getIndex(char c) {
    int index = c - 'A';
    if (c >= 'a') {
      index = (c - 'a') + 26;
    }
    return index;
  }

  private boolean backtrack(char[][] board, int column, int row,
                            String word, int index) {
    if (index == word.length()) {
      return true;
    }
    if (column < 0 || board.length <= column
      || row < 0 || board[column].length <= row
      || board[column][row] != word.charAt(index)) {
      return false;
    }
    board[column][row] = '.';
    // 上
    boolean found = backtrack(board, column - 1, row, word, index + 1);
    if (found) {
      return true;
    }
    // 下
    found = backtrack(board, column + 1, row, word, index + 1);
    if (found) {
      return true;
    }
    // 左
    found = backtrack(board, column, row - 1, word, index + 1);
    if (found) {
      return true;
    }
    // 右
    found = backtrack(board, column, row + 1, word, index + 1);
    if (found) {
      return true;
    }
    board[column][row] = word.charAt(index);
    return false;
  }
  // end::answer[]
}
