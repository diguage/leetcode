package com.diguage.algo.leetcode;

public class _0794_ValidTicTacToeState {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-07 21:52:04
   */
  public boolean validTicTacToe(String[] board) {
    int length = board.length;
    char[][] grid = new char[length][length];
    int xc = 0, oc = 0;
    boolean xRowOver = false;
    boolean oRowOver = false;
    for (int row = 0; row < length; row++) {
      char[] chars = board[row].toCharArray();
      int ixc = 0;
      int ioc = 0;
      for (int column = 0; column < chars.length; column++) {
        char c = chars[column];
        if (c == 'X') {
          xc++;
          ixc++;
        } else if (c == 'O') {
          oc++;
          ioc++;
        }
        grid[row][column] = c;
      }
      if (!xRowOver && ixc == 3) {
        xRowOver = true;
      }
      if (!oRowOver && ioc == 3) {
        oRowOver = true;
      }
    }
    // X 必须比 O 多，但是最多能多一个
    // O 不会比 X 多
    if (xc - oc > 1 || oc - xc >= 1) {
      return false;
    }
    boolean xColOver = false;
    boolean oColOver = false;
    for (int i = 0; i < length; i++) {
      xColOver = grid[0][i] == 'X' && grid[1][i] == 'X' && grid[2][i] == 'X';
      oColOver = grid[0][i] == 'O' && grid[1][i] == 'O' && grid[2][i] == 'O';
      if (xColOver || oColOver) {
        break;
      }
    }
    boolean xDiagOver = (grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X')
      || (grid[0][2] == 'X' && grid[1][1] == 'X' && grid[2][0] == 'X');
    boolean oDiagOver = (grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == 'O')
      || (grid[0][2] == 'O' && grid[1][1] == 'O' && grid[2][0] == 'O');
    // 如果 X 获胜，则 X 比 O 多一个
    if ((xRowOver || xColOver || xDiagOver) && xc - oc != 1) {
      return false;
    }
    // 如果 O 获胜，则 X 与 O 个数相等
    if ((oRowOver || oColOver || oDiagOver) && xc != oc) {
      return false;
    }
    return true;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0794_ValidTicTacToeState()
      .validTicTacToe(new String[]{"OXX", "XOX", "OXO"});
  }
}
