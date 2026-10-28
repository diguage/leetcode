package com.diguage.algo.leetcode;

public class _0079_WordSearch_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-28 23:35:16
   */
  public boolean exist(char[][] board, String word) {
    char[] chars = word.toCharArray();
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[r].length; c++) {
        if (board[r][c] == chars[0]) {
          boolean found = backtrack(board, r, c, chars, 0);
          if (found) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean backtrack(char[][] board, int r, int c,
                            char[] chars, int i) {
    if (i >= chars.length) {
      return true;
    }
    if (r < 0 || r >= board.length
      || c < 0 || c >= board[r].length
      || board[r][c] != chars[i]) {
      return false;
    }
    board[r][c] = '.';
    if (backtrack(board, r - 1, c, chars, i + 1)
      || backtrack(board, r + 1, c, chars, i + 1)
      || backtrack(board, r, c - 1, chars, i + 1)
      || backtrack(board, r, c + 1, chars, i + 1)) {
      return true;
    }
    board[r][c] = chars[i];
    return false;
  }
  // end::answer[]
}
