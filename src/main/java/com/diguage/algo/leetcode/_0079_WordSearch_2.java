package com.diguage.algo.leetcode;

public class _0079_WordSearch_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-21 21:39:49
   */
  public boolean exist(char[][] board, String word) {
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[r].length; c++) {
        if (board[r][c] == word.charAt(0)) {
          if (backtrack(board, r, c, word, 0)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean backtrack(char[][] board, int row, int column,
                            String word, int idx) {
    if (idx >= word.length()) {
      return true;
    }
    if (row < 0 || row >= board.length
      || column < 0 || column >= board[row].length
      || board[row][column] == ' '
      || board[row][column] != word.charAt(idx)) {
      return false;
    }
    board[row][column] = ' ';
    boolean result = backtrack(board, row - 1, column, word, idx + 1)
      || backtrack(board, row + 1, column, word, idx + 1)
      || backtrack(board, row, column - 1, word, idx + 1)
      || backtrack(board, row, column + 1, word, idx + 1);
    board[row][column] = word.charAt(idx);
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    _0079_WordSearch_2 solution = new _0079_WordSearch_2();
    char[][] board = {
      {'A', 'B', 'C', 'E'},
      {'S', 'F', 'C', 'S'},
      {'A', 'D', 'E', 'E'}};
    String w1 = "ABCCED";
    boolean r1 = solution.exist(board, w1);
    System.out.println((r1) + " : " + r1);

    String w2 = "SEE";
    boolean r2 = solution.exist(board, w2);
    System.out.println((r2) + " : " + r2);

    String w3 = "ABCB";
    boolean r3 = solution.exist(board, w3);
    System.out.println((!r3) + " : " + r3);
  }
}
