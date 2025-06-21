package com.diguage.algo.leetcode;

public class _0036_ValidSudoku_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-21 21:07:23
   */
  public boolean isValidSudoku(char[][] board) {
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
        if (rows[r][idx] || cols[c][idx] || blocks[r / 3][c / 3][idx]) {
          return false;
        }
        rows[r][idx] = true;
        cols[c][idx] = true;
        blocks[r / 3][c / 3][idx] = true;
      }
    }
    return true;
  }
  // end::answer[]
  public static void main(String[] args) {
    char[][] b = {
//      {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
//      {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
//      {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
//      {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
//      {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
//      {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
//      {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
//      {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
//      {'9', '.', '.', '.', '.', '.', '.', '.', '.'}

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
    boolean r = new _0036_ValidSudoku_2().isValidSudoku(b);
    System.out.println(r);
  }
}
