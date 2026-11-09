package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0051_NQueens_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-09 22:12:06
   */
  public List<List<String>> solveNQueens(int n) {
    char[][] board = new char[n][n];
    for (char[] chars : board) {
      Arrays.fill(chars, '.');
    }
    List<List<String>> result = new ArrayList<>();
    backtrack(result, board, 0);
    return result;
  }

  private void backtrack(List<List<String>> result, char[][] board, int row) {
    int n = board.length;
    if (row == n) {
      List<String> list = new ArrayList<>();
      for (char[] chars : board) {
        list.add(new String(chars));
      }
      result.add(list);
      return;
    }
    for (int i = 0; i < n; i++) {
      if (!isValid(board, row, i)) {
        continue;
      }
      board[row][i] = 'Q';
      backtrack(result, board, row + 1);
      board[row][i] = '.';
    }
  }

  private boolean isValid(char[][] board, int row, int col) {
    int length = board.length;
    for (int i = 0; i < length; i++) {
      // 行
      if (board[row][i] == 'Q') {
        return false;
      }
      // 列
      if (board[i][col] == 'Q') {
        return false;
      }
      // 正对角线
      if (row - i - 1 >= 0 && col - i - 1 >= 0 && board[row - i - 1][col - i - 1] == 'Q') {
        return false;
      }
      if (row + i + 1 < length && col + i + 1 < length && board[row + i + 1][col + i + 1] == 'Q') {
        return false;
      }
      // 反对角线
      if (row - i - 1 >= 0 && col + i + 1 < length && board[row - i - 1][col + i + 1] == 'Q') {
        return false;
      }
      if (row + i + 1 < length && col - i - 1 >= 0 && board[row + i + 1][col - i - 1] == 'Q') {
        return false;
      }
    }
    return true;
  }
  // end::answer[]

  static void main() {
    new _0051_NQueens_3().solveNQueens(4);
  }
}
