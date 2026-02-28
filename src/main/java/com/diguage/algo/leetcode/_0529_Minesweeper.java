package com.diguage.algo.leetcode;

public class _0529_Minesweeper {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-28 22:55:52
   */
  public char[][] updateBoard(char[][] board, int[] click) {
    int row = click[0];
    int column = click[1];
    if (row < 0 || row >= board.length
      || column < 0 || column >= board[row].length) {
      return board;
    }
    char c = board[row][column];
    if (c == 'B' || c == 'X'
      || ('1' <= c && c <= '8')) {
      return board;
    }
    if (c == 'M') {
      board[row][column] = 'X';
      return board;
    }
    if (c == 'E') {
      int cnt = countMine(board, row, column);
      // 如果周围有地雷
      if (cnt > 0) {
        board[row][column] = (char) ('0' + cnt);
      } else {
        board[row][column] = 'B';
        // 如果周围没有地雷
        updateBoard(board, new int[]{row - 1, column});
        updateBoard(board, new int[]{row + 1, column});
        updateBoard(board, new int[]{row, column - 1});
        updateBoard(board, new int[]{row, column + 1});
        updateBoard(board, new int[]{row - 1, column - 1});
        updateBoard(board, new int[]{row - 1, column + 1});
        updateBoard(board, new int[]{row + 1, column - 1});
        updateBoard(board, new int[]{row + 1, column + 1});
      }
    }
    return board;
  }

  private int countMine(char[][] board, int row, int column) {
    int result = 0;
    // 上
    if (row - 1 >= 0 && board[row - 1][column] == 'M') {
      result++;
    }
    // 下
    if (row + 1 < board.length && board[row + 1][column] == 'M') {
      result++;
    }
    // 左
    if (column - 1 >= 0 && board[row][column - 1] == 'M') {
      result++;
    }
    // 右
    if (column + 1 < board[row].length && board[row][column + 1] == 'M') {
      result++;
    }

    // 左上
    if (row - 1 >= 0 && column - 1 >= 0 && board[row - 1][column - 1] == 'M') {
      result++;
    }
    // 右上
    if (row - 1 >= 0 && column + 1 < board[row - 1].length && board[row - 1][column + 1] == 'M') {
      result++;
    }
    // 左下
    if (row + 1 < board.length && column - 1 >= 0 && board[row + 1][column - 1] == 'M') {
      result++;
    }
    // 右下
    if (row + 1 < board.length && column + 1 < board[row + 1].length && board[row + 1][column + 1] == 'M') {
      result++;
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0529_Minesweeper().updateBoard(
      new char[][]{
        {'E', 'E', 'E', 'E', 'E'},
        {'E', 'E', 'M', 'E', 'E'},
        {'E', 'E', 'E', 'E', 'E'},
        {'E', 'E', 'E', 'E', 'E'}},
      new int[]{3, 0});
  }
}
