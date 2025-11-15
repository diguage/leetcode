package com.diguage.algo.leetcode;

public class _0079_WordSearch_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-15 08:52:34
   */
  public boolean exist(char[][] board, String word) {
    for (int c = 0; c < board.length; c++) {
      for (int r = 0; r < board[c].length; r++) {
        if (board[c][r] == word.charAt(0)) {
          boolean found = backtrack(board, word, c, r, 0);
          if (found) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean backtrack(char[][] board, String word,
                            int column, int row, int index) {
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
    boolean found = backtrack(board, word, column - 1, row, index + 1);
    if (found) {
      return true;
    }
    // 下
    found = backtrack(board, word, column + 1, row, index + 1);
    if (found) {
      return true;
    }
    // 左
    found = backtrack(board, word, column, row - 1, index + 1);
    if (found) {
      return true;
    }
    // 右
    found = backtrack(board, word, column, row + 1, index + 1);
    if (found) {
      return true;
    }
    board[column][row] = word.charAt(index);
    return false;
  }
  // end::answer[]
}
