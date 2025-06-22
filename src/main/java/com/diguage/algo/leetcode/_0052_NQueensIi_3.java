package com.diguage.algo.leetcode;

public class _0052_NQueensIi_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2020-02-05 16:25
   */
  public int totalNQueens(int n) {
    boolean[][] board = new boolean[n][n];
    return backtrack(board, 0, 0, 0);
  }

  private int backtrack(boolean[][] board, int row, int col, int cnt) {
    int length = board.length;
    if (row >= length && cnt == length) {
      return 1;
    }
    int result = 0;
    for (int r = row; r < length; r++) {
      for (int c = col; c < length; c++) {
        if (isValid(board, r, c)) {
          board[r][c] = true;
          result += backtrack(board, r + 1, 0, cnt + 1);
          board[r][c] = false;
        } else {
          // 如果一行中都没有可以放置的，则不是正确解
          if (c == length - 1) {
            return result;
          }
        }
      }
    }
    return result;
  }

  private boolean isValid(boolean[][] board, int row, int col) {
    int length = board.length;
    for (int i = 0; i < length; i++) {
      if (board[row][i]) {
        return false;
      }
      if (board[i][col]) {
        return false;
      }
      if (row - i >= 0 && col - i >= 0 && board[row - i][col - i]) {
        return false;
      }
      // 右下方对角线还没处理到，不需要判断
      // if (row + i < length && col + i < length && board[row + i][col + i]) {
      //   return false;
      // }
      if (row - i >= 0 && col + i < length && board[row - i][col + i]) {
        return false;
      }
      // 左下方对角线还没处理到，不需要判断
      // if (row + i < length && col - i >= 0 && board[row + i][col - i]) {
      //   return false;
      // }
    }
    return true;
  }

  // end::answer[]
  public static void main(String[] args) {
    int result = new _0052_NQueensIi_3().totalNQueens(4);
    System.out.println(result);
  }
}
