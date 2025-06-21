package com.diguage.algo.leetcode;

public class _0037_SudokuSolver_4 {
  // tag::answer[]
  /**
   * * @author D瓜哥 · https://www.diguage.com
   * * @since 2025-06-21 22:01:54
   */
  public void solveSudoku(char[][] board) {
    int length = board.length;
    boolean[][] rows = new boolean[length][length];
    boolean[][] cols = new boolean[length][length];
    boolean[][][] blocks = new boolean[3][3][length];
    for (int r = 0; r < length; r++) {
      for (int c = 0; c < length; c++) {
        char ac = board[r][c];
        if (ac == '.') {
          continue;
        }
        int idx = ac - '1';
        rows[r][idx] = true;
        cols[c][idx] = true;
        blocks[r / 3][c / 3][idx] = true;
      }
    }
    backtrack(board, rows, cols, blocks, 0);
  }

  private boolean backtrack(char[][] board, boolean[][] rows, boolean[][] cols,
                            boolean[][][] blocks, int index) {
    if (index == board.length * board.length) {
      return true;
    }
    int row = index / 9;
    int col = index % 9;
    if (board[row][col] != '.') {
      return backtrack(board, rows, cols, blocks, index + 1);
    }
    for (int i = 0; i < 9; i++) {
      if (rows[row][i] || cols[col][i] || blocks[row / 3][col / 3][i]) {
        continue;
      }
      rows[row][i] = true;
      cols[col][i] = true;
      blocks[row / 3][col / 3][i] = true;
      board[row][col] = (char) (i + '1');
      if (backtrack(board, rows, cols, blocks, index + 1)) {
        return true;
      }
      board[row][col] = '.';
      rows[row][i] = false;
      cols[col][i] = false;
      blocks[row / 3][col / 3][i] = false;
    }
    return false;
  }
  // end::answer[]
}
