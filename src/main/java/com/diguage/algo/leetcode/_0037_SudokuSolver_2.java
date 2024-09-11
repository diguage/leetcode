package com.diguage.algo.leetcode;

import static com.diguage.util.Printers.printMatrix;

public class _0037_SudokuSolver_2 {
  // tag::answer[]

  /**
   * * @author D瓜哥 · https://www.diguage.com
   * * @since 2024-09-11 10:59:08
   */
  public void solveSudoku(char[][] board) {
    backtracking(board);
  }

  private boolean backtracking(char[][] board) {
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[r].length; c++) {
        if (board[r][c] != '.') {
          continue;
        }
        // 根据限制条件，筛选出可选字符，否则重复判断
        char[] chars = selectChars(board, r, c);
        for (char sc : chars) {
          board[r][c] = sc;
          printMatrix(board);
          if (backtracking(board)) {
            return true;
          }
          board[r][c] = '.';
        }
        return false;
      }
    }
    return true;
  }

  private char[] selectChars(char[][] board, int row, int column) {
    char[] chars = new char[9];
    int length = 9;
    for (int i = 0; i < chars.length; i++) {
      chars[i] = (char) ('1' + i);
    }
    for (int i = 0; i < board.length; i++) {
      char c = board[i][column];
      if (c != '.' && chars[c - '1'] != '.') {
        chars[c - '1'] = '.';
        length--;
        if (length == 0) {
          return new char[0];
        }
      }
    }
    for (int i = 0; i < board[row].length; i++) {
      char c = board[row][i];
      if (c != '.' && chars[c - '1'] != '.') {
        chars[c - '1'] = '.';
        length--;
        if (length == 0) {
          return new char[0];
        }
      }
    }
    row = (row / 3) * 3;
    column = (column / 3) * 3;
    for (int i = row; i < row + 3; i++) {
      for (int j = column; j < column + 3; j++) {
        char c = board[i][j];
        if (c != '.' && chars[c - '1'] != '.') {
          chars[c - '1'] = '.';
          length--;
          if (length == 0) {
            return new char[0];
          }
        }
      }
    }
    char[] result = new char[length];
    for (int i = chars.length - 1; i >= 0; i--) {
      if (chars[i] != '.') {
        result[--length] = chars[i];
      }
    }
    return result;
  }

  // end::answer[]
  public static void main(String[] args) {
    char[][] b1 = {
      {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
      {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
      {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
      {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
      {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
      {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
      {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
      {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
      {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    _0037_SudokuSolver_2 solution = new _0037_SudokuSolver_2();
    solution.solveSudoku(b1);
    printMatrix(b1);
  }
}
